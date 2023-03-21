package edu.stanford.radx.radxmetadatacompiler.cli;

import edu.stanford.radx.radxmetadatacompiler.nihreporter.NiHReporterService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Mixin;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-10
 */
@Component
@Command(name = "check-metadata")
public class CheckMetadataCommand implements CliCommand {

    @Mixin
    private IoMixin io;

    private final NiHReporterService reporterService;

    public CheckMetadataCommand(NiHReporterService reporterService) {
        this.reporterService = reporterService;
    }

    @Override
    public Integer call() throws Exception {
        io.in.stream()
                .flatMap(this::resolve)
                .peek(System.err::println)
             .filter(inPath -> inPath.getFileName().toString().endsWith(".csv"))
             .forEach(this::processCsvFile);
        return 0;
    }

    private Stream<Path> resolve(Path p) {
        try {
            if(Files.isDirectory(p)) {
                return Files.list(p);
            }
            else {
                return Stream.of(p);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return Stream.of();
        }
    }

    private void processCsvFile(Path inPath) {
        try {
            CSVParser parser = new CSVParser(new FileReader(inPath.toFile(), StandardCharsets.UTF_8), CSVFormat.DEFAULT);
            parser.stream()
                    .filter(this::isNihProjectId)
                    .map(record -> record.get(1))
                    .map(this::normalizeProjectId)
                    .peek(System.err::println)
                    .forEach(this::checkProjectId);
            Thread.sleep(500); // Throttle for fair usage
        } catch (IOException | InterruptedException e) {
            System.err.println("Error processing CSV File");
        }
    }

    private void checkProjectId(String s) {
        try {
            var projectDetails = reporterService.getProjectDetails(s);
            if(projectDetails.isEmpty()) {
                System.err.println("Project not found: " + s);
            }
            else {
                var pd = projectDetails.get();
                System.err.println("Project exists: " + pd.projectNum());
                System.err.println("                " + pd.projectNumberSplit().getShortNumber());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private boolean isNihProjectId(CSVRecord record) {
        return record.get(0).trim().toLowerCase().replace("_", "").equals("nihprojectid");
    }

    private String normalizeProjectId(String projectId) {
        if(projectId.trim().startsWith("NIH-")) {
            projectId = projectId.trim().substring(4);
        }
        var matcher = Pattern.compile("^[0-9]+-").matcher(projectId);
        if(matcher.find()) {
           projectId = projectId.substring(matcher.end());
        }
        return projectId.trim();
    }
}
