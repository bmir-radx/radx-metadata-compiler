package edu.stanford.radx.radxmetadatacompiler.nihreporter;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-10
 */
public record ProjectSearchResult(@JsonProperty("results") List<ProjectDetails> results) {

}
