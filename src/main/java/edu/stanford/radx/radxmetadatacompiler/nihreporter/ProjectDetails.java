package edu.stanford.radx.radxmetadatacompiler.nihreporter;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public record ProjectDetails(@JsonProperty("project_num") String projectNum,
                             @JsonProperty("project_num_split") ProjectNumberSplit projectNumberSplit,
                             @JsonProperty("project_title") String projectTitle,
                             @JsonProperty("principal_investigators") List<PiDetails> principalInvestigators,
                             @JsonProperty("project_start_date") Instant projectStartDate,
                             @JsonProperty("project_end_date") Instant projectEndDate,
                             @JsonProperty("phr_text") String phrText,
                             @JsonProperty("pref_terms") String prefTerms,
                             @JsonProperty("organization") OrganizationDetails organization) {


    public List<String> getPrefTerms() {
        return Stream.of(prefTerms.split(";"))
                .toList();
    }

    public Optional<PiDetails> getContactPi() {
        return principalInvestigators.stream().filter(PiDetails::isContactPi).findFirst();
    }
}
