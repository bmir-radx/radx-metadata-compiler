package edu.stanford.radx.radxmetadatacompiler.nihreporter;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProjectNumberSplit(@JsonProperty("appl_type_code") String applTypeCode,
                                         @JsonProperty("activity_code") String activityCode,
                                         @JsonProperty("ic_code") String icCode,
                                         @JsonProperty("serial_num") String serialNumber,
                                         @JsonProperty("support_year") String supportYear,
                                         @JsonProperty("full_support_year") String fullSupportYear,
                                         @JsonProperty("suffix_code") String suffixCode) {

    public String getShortNumber() {
        return activityCode + icCode + serialNumber;
    }

}
