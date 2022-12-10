package edu.stanford.radx.radxmetadatacompiler.cli;

import edu.stanford.radx.radxmetadatacompiler.CreateMetadata;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import picocli.CommandLine.Mixin;

import java.io.IOException;
import java.nio.file.Files;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-08
 */
@Component
@CommandLine.Command(name = "create-metadata")
public class CreateMetadataCommand implements CliCommand {

    @Mixin
    private IoMixin io;

    private final CreateMetadata createMetadata;

    public CreateMetadataCommand(CreateMetadata createMetadata) {
        this.createMetadata = createMetadata;
    }

    @Override
    public Integer call() throws Exception {
        for(var pth : io.in) {
            if(Files.isDirectory(pth)) {
                Files.list(pth).filter(filePath -> {
                    System.out.println(filePath);
                    return filePath.getFileName().toString()
                            .endsWith(".json");
                }).forEach(filePath -> {
                    try {
                        System.out.println("PROC");
                        createMetadata.create(filePath, io.out);
                    } catch (IOException | TemplateException e) {
                        System.err.println(e.getMessage());
                        throw new RuntimeException(e);
                    }
                });
            }
            else {
                createMetadata.create(pth, io.out);
            }
        }
        return 0;
    }
}
