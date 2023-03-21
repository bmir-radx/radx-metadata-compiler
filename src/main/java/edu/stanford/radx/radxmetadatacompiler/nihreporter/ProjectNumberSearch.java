package edu.stanford.radx.radxmetadatacompiler.nihreporter;

public record ProjectNumberSearch(String projectNumber, int offset, int limit) {

    private static final String template = """
            {
                    "criteria":
                    {
                        "project_nums": ["${projectNumber}"]
                    },
                    "include_fields": [
                    "ApplId","SubprojectId","FiscalYear","ProjectNum","ProjectSerialNum","Organization", "OrganizationType",
                                                                  "AwardType", "ActivityCode", "AwardAmount", "ProjectNumSplit", "PrincipalInvestigators", "ProgramOfficers", "AgencyIcAdmin", "AgencyIcFundings","CongDist", "ProjectStartDate","ProjectEndDate","FullFoa","FullStudySection", "AwardNoticeDate", "CoreProjectNum","PrefTerms", "ProjectTitle", "PhrText","SpendingCategoriesDesc", "ArraFunded", "BudgetStart", "BudgetEnd","CfdaCode","FundingMechanism","DirectCostAmt","IndirectCostAmt"
                 ],
                    "offset":${offset},
                        "limit":${limit},
                        "sort_field":"project_start_date",
                        "sort_order":"desc"
                }
            """;

    public String getQuery() {
        return template.replace("${projectNumber}", projectNumber)
                .replace("${offset}", Integer.toString(offset))
                .replace("${limit}", Integer.toString(limit));
    }


}
