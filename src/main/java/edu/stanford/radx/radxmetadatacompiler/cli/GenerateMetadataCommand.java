package edu.stanford.radx.radxmetadatacompiler.cli;

import edu.stanford.radx.radxmetadatacompiler.CreateMetadata;
import edu.stanford.radx.radxmetadatacompiler.Csv;
import edu.stanford.radx.radxmetadatacompiler.CsvLoader;
import freemarker.template.TemplateException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import picocli.CommandLine.Mixin;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-08
 */
@Component
@CommandLine.Command(name = "generate-metadata")
public class GenerateMetadataCommand implements CliCommand {

    @Mixin
    private IoMixin io;

    private final CreateMetadata createMetadata;

    private final CsvLoader csvLoader;

    public GenerateMetadataCommand(CreateMetadata createMetadata, CsvLoader csvLoader) {
        this.createMetadata = createMetadata;
        this.csvLoader = csvLoader;
    }

    @Override
    public Integer call() throws Exception {
        for(var pth : io.in) {
            if(Files.isDirectory(pth)) {
                Files.list(pth).filter(this::isCsvFile).forEach(p -> processCsvFile(p, io.out));
            }
            else if(isCsvFile(pth)) {
                processCsvFile(pth, io.out);
            }
        }
        return 0;
    }

    private boolean isCsvFile(Path filePath) {
        return filePath.getFileName().toString().endsWith(".csv");
    }

    private void processCsvFile(Path filePath, Path out) {
            var csv = toCsv(filePath);
            csv.ifPresent(c -> {
                try {
                    createMetadata.create(c, filePath, out);
                } catch (IOException | TemplateException e) {
                    System.err.println("Could not process CSV file: " + e.getMessage());
                }
            });

    }

    private Optional<Csv> toCsv(Path csvFilePath) {
        try {
            return Optional.of(csvLoader.loadCsv(csvFilePath));
        } catch (IOException e) {
            System.err.println("Error loading CSV file: " + e.getMessage());
            return Optional.empty();
        }

    }
}
