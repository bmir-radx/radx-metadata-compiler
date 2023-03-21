package edu.stanford.radx.radxmetadatacompiler.cli;

import edu.stanford.radx.radxmetadatacompiler.nihreporter.NiHReporterService;
import edu.stanford.radx.radxmetadatacompiler.nihreporter.PiDetails;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-10
 */
@Component
@Command(name = "project-details")
public class ProjectDetailsCommand implements CliCommand {

    @Option(names = "--project-number", required = true)
    private String projectNumber;

    private final NiHReporterService reporterService;


    public ProjectDetailsCommand(NiHReporterService reporterService) {
        this.reporterService = reporterService;
    }

    @Override
    public Integer call() throws Exception {
        var result = reporterService.getProjectDetails(projectNumber);
        result.ifPresentOrElse(r -> {
            System.err.println("Project found");
            System.err.printf("Project Number: %s\n", r.projectNum());
            System.err.printf("Project Title: %s\n", r.projectTitle());
            System.err.printf("Project Start Date: %s\n", r.projectStartDate());
            System.err.printf("Project End Date: %s\n", r.projectEndDate());
            System.err.printf("Project PI: %s\n",
                              r.principalInvestigators()
                               .stream()
                               .findFirst()
                               .map(PiDetails::fullName)
                               .orElse("Not specified"));
        }, () -> {
            System.err.println("Project not found");
        });
        return 0;
    }
}
