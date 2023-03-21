package edu.stanford.radx.radxmetadatacompiler.nihreporter;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-10
 */
public record OrganizationDetails(@JsonProperty("org_name") String orgName) {

}
