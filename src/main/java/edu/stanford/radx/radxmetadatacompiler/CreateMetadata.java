package edu.stanford.radx.radxmetadatacompiler;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stanford.radx.radxmetadatacompiler.nihreporter.NiHReporterService;
import edu.stanford.radx.radxmetadatacompiler.nihreporter.PiDetails;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-07
 */
@Component
public class CreateMetadata {

    private final ObjectMapper objectMapper;

    private final Configuration configuration;

    private final NiHReporterService reporterService;

    public CreateMetadata(ObjectMapper objectMapper, Configuration configuration, NiHReporterService reporterService) {
        this.objectMapper = objectMapper;
        this.configuration = configuration;
        this.reporterService = reporterService;
    }

    public void create(Csv inputCsv, Path csvPath, Path out) throws IOException, TemplateException {

        var branchesCsvs = new BranchTransform().transformCsv(inputCsv);
        System.err.printf("Processing %s\n", csvPath);
        System.err.printf("Found %d data files listed in CSV metadata\n", branchesCsvs.size());
        for (var branchedCsv : branchesCsvs.entrySet()) {
            System.err.printf("Processing data file: %s\n", branchedCsv.getKey());
            var csv = branchedCsv.getValue();
            var csv2Json = new Csv2Json();
            var jsonObject = csv2Json.convertToJson(csv, "Field", Set.of("contact_PI", "creator", "keywords", "publication_url"),
                                   Collections.emptySet(), Collections.emptySet());

            System.err.println("------------------------------------------------------------------------");
            System.err.println(csvPath);
            var template = configuration.getTemplate("metadata-template.ftlh");
            var projectId = (Map<String, Object>) jsonObject.get("NIH_project_ID");
            if(projectId == null) {
                projectId = (Map<String, Object>) jsonObject.get("NIH project ID");
            }
            if(projectId != null) {
                var val = projectId.get("Value").toString();
                System.err.printf("Specified projectId: %s\n", val);
                if(val.startsWith("NIH-")) {
                    val = val.substring(4);
                }
                System.err.printf("Normalized projectId: %s\n", val);
                var pd = reporterService.getProjectDetails(val);
                pd.ifPresent(details -> {
                    jsonObject.put("startDate", details.projectStartDate().toString());
                    jsonObject.put("endDate", details.projectEndDate().toString());
                });
            }
            jsonObject.put("uuid", new Object() {
                @Override
                public String toString() {
                    return UUID.randomUUID().toString();
                }
            });

            var stringWriter = new StringWriter();
            template.process(jsonObject, stringWriter);
            Files.writeString(Path.of("/tmp/md.json"), stringWriter.toString());
            var read = objectMapper.createParser(stringWriter.toString()).readValueAs(Map.class);
            var dataFileName = branchedCsv.getKey();
            if(dataFileName.endsWith(".csv")) {
                dataFileName = dataFileName.replace(".csv", ".json");
            }
            else {
                dataFileName = dataFileName + ".json";
            }
            var outputFile = out.resolve(dataFileName.replace("DATA", "META"));
            System.err.println("    Outputting " + outputFile);
            Files.createDirectories(outputFile.getParent());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputFile.toFile(), read);
        }

    }
}
