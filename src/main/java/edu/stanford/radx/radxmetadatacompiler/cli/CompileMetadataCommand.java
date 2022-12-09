package edu.stanford.radx.radxmetadatacompiler.cli;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-08
 */
@Command(name = "cm")
public class CompileMetadataCommand implements Callable<Integer> {

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "display this help message")
    boolean usageHelpRequested;

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
