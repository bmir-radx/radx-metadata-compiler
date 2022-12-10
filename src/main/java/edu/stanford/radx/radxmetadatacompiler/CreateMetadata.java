package edu.stanford.radx.radxmetadatacompiler;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-07
 */
@Component
public class CreateMetadata {

    private final ObjectMapper objectMapper;

    private final Configuration configuration;

    public CreateMetadata(ObjectMapper objectMapper, Configuration configuration) {
        this.objectMapper = objectMapper;
        this.configuration = configuration;
    }

    public void create(Path path, Path out) throws IOException, TemplateException {

        var template = configuration.getTemplate("metadata-template.ftlh");
        var m = objectMapper.createParser(path.toFile()).readValueAs(Map.class);

        m.put("uuid", new Object() {
            @Override
            public String toString() {
                return UUID.randomUUID().toString();
            }
        });

        var stringWriter = new StringWriter();
        template.process(m, stringWriter);
        Files.writeString(Path.of("/tmp/md.json"), stringWriter.toString());
        var read = objectMapper.createParser(stringWriter.toString()).readValueAs(Map.class);
        var outputFile = out.resolve(path.getFileName().toString());
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputFile.toFile(), read);

    }
}
