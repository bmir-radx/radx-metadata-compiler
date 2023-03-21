package edu.stanford.radx.radxmetadatacompiler.nihreporter;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-10
 */
public record PiDetails(@JsonProperty("profile_id") String profileId,
                                @JsonProperty("first_name") String firstName,
                                @JsonProperty("middle_name") String middleName,
                                @JsonProperty("last_name") String lastName,
                                @JsonProperty("is_contact_pi") boolean isContactPi,
                                @JsonProperty("full_name") String fullName,
                                @JsonProperty("title") String title) {

}
