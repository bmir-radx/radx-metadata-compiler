package edu.stanford.radx.radxmetadatacompiler;

import edu.stanford.radx.radxmetadatacompiler.nihreporter.OrganizationDetails;
import edu.stanford.radx.radxmetadatacompiler.nihreporter.ProjectDetails;
import edu.stanford.radx.radxmetadatacompiler.nihreporter.ProjectNumberSplit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-10
 */
@SpringBootTest
@AutoConfigureJsonTesters
public class ProjectDetailsTestCase {

    @Autowired
    private JacksonTester<ProjectDetails> tester;

    @Test
    void shouldParseProjectDetails() throws IOException {
        var json = """
                {
                            "appl_id": 10320986,
                            "subproject_id": null,
                            "fiscal_year": 2022,
                            "project_num": "4U01AA029316-02",
                            "project_serial_num": "AA029316",
                            "organization": {
                                "org_name": "UNIVERSITY OF WASHINGTON",
                                "city": null,
                                "country": null,
                                "org_city": "SEATTLE",
                                "org_country": "UNITED STATES",
                                "org_state": "WA",
                                "org_state_name": null,
                                "dept_type": "ENGINEERING (ALL TYPES)",
                                "fips_country_code": null,
                                "org_duns": [
                                    "605799469"
                                ],
                                "org_ueis": [
                                    "HD1WMN6945W6"
                                ],
                                "primary_duns": "605799469",
                                "primary_uei": "HD1WMN6945W6",
                                "org_fips": "US",
                                "org_ipf_code": "9087701",
                                "org_zipcode": "981959472",
                                "external_org_id": 9087701
                            },
                            "award_type": "4N",
                            "activity_code": "U01",
                            "award_amount": 455938,
                            "project_num_split": {
                                "appl_type_code": "4",
                                "activity_code": "U01",
                                "ic_code": "AA",
                                "serial_num": "029316",
                                "support_year": "02",
                                "full_support_year": "02",
                                "suffix_code": ""
                            },
                            "principal_investigators": [
                                {
                                    "profile_id": 8012149,
                                    "first_name": "Suzie",
                                    "middle_name": "H.",
                                    "last_name": "Pun",
                                    "is_contact_pi": true,
                                    "full_name": "Suzie H. Pun",
                                    "title": "PROFESSOR"
                                },
                                {
                                    "profile_id": 11273504,
                                    "first_name": "Joshua",
                                    "middle_name": "R",
                                    "last_name": "Smith",
                                    "is_contact_pi": false,
                                    "full_name": "Joshua R Smith",
                                    "title": ""
                                }
                            ],
                            "program_officers": [
                                {
                                    "first_name": "Changhai",
                                    "middle_name": "",
                                    "last_name": "Cui",
                                    "full_name": "Changhai  Cui"
                                }
                            ],
                            "agency_ic_admin": {
                                "code": "AA",
                                "abbreviation": "NIAAA",
                                "name": "National Institute on Alcohol Abuse and Alcoholism"
                            },
                            "agency_ic_fundings": [
                                {
                                    "fy": 2022,
                                    "code": "OD",
                                    "name": "NIH Office of the Director",
                                    "abbreviation": "OD",
                                    "total_cost": 455938.0
                                }
                            ],
                            "cong_dist": "WA-07",
                            "project_start_date": "2020-12-21T12:12:00Z",
                            "project_end_date": "2023-11-30T12:11:00Z",
                            "organization_type": {
                                "name": "SCHOOLS OF MEDICINE",
                                "code": "10",
                                "is_other": false
                            },
                            "full_foa": "RFA-OD-20-014",
                            "full_study_section": {
                                "srg_code": "ZAA1",
                                "srg_flex": "",
                                "sra_designator_code": "DD",
                                "sra_flex_code": "",
                                "group_code": "",
                                "name": "ZAA1-DD(14)R"
                            },
                            "award_notice_date": "2021-12-01T12:12:00Z",
                            "core_project_num": "U01AA029316",
                            "pref_terms": "2019-nCoV;Affinity;Air;Antibodies;Binding;Binding Proteins;Biosensing Techniques;Biosensor;COVID-19;COVID-19 detection;COVID-19 pandemic;COVID-19 patient;Car Phone;Cellular Phone;Cessation of life;Chemistry;Clinical;Contact Tracing;Coronavirus;Detection;Development;Devices;Disease Outbreaks;Early Diagnosis;Electric Capacitance;Electrodes;Electronics;Engineering;Evaluation;Exhibits;Face;Frequencies;Future;Glass;Goals;Hospitals;Immobilization;Individual;Infection;Label;Libraries;Measures;Middle East Respiratory Syndrome;Molecular Conformation;Natural regeneration;Oxidation-Reduction;Pathogen detection;Pattern;Performance;Preparation;Process;Reporting;Restaurants;SARS coronavirus;SARS-CoV-2 spike protein;SARS-CoV-2 transmission;Sampling;Sensitivity and Specificity;Signal Transduction;Specificity;Surface;System;Technology;Testing;Time;Touch sensation;Vaccines;Validation;Virion;Work;aptamer;base;cost;density;design;infection rate;instrumentation;nanofabrication;new technology;novel;prevent;secondary infection;sensor;touchscreen;transmission process;viral detection;viral transmission",
                            "project_title": "Touchscreen-compatible, real-time electrochemical sensing of SARS-CoV-2",
                            "phr_text": "PROJECT NARRATIVE\\nThere is an urgent need for new and rapidly translatable technologies that can reduce SARS-CoV-2\\ntransmission. The main goal of this proposal is to develop an integrated biosensor-touchscreen that sensitively\\nreports surface contact with SARS-CoV-2. Successful completion of these aims will result in a novel automatic\\nsensing platform for SARS-CoV-2 that could also applied to multi-user touchscreen devices such as those found\\nin hospitals, airports, and restaurants, as well as single-user touchscreen such as mobile phones.",
                            "spending_categories_desc": null,
                            "arra_funded": "N",
                            "budget_start": "2021-12-01T12:12:00Z",
                            "budget_end": "2023-11-30T12:11:00Z",
                            "cfda_code": "273",
                            "funding_mechanism": "Non-SBIR/STTR",
                            "direct_cost_amt": 293208,
                            "indirect_cost_amt": 162730
                        }
                """;
        var content = tester.parse(json);
        var projectDetails = content.getObject();
        assertThat(projectDetails.projectNum()).isEqualTo("4U01AA029316-02");
        assertThat(projectDetails.principalInvestigators()).hasSize(2);
        assertThat(projectDetails.projectStartDate()).isEqualTo(Instant.parse("2020-12-21T12:12:00Z"));
        assertThat(projectDetails.projectEndDate()).isEqualTo(Instant.parse("2023-11-30T12:11:00Z"));
        assertThat(projectDetails.projectTitle()).isEqualTo("Touchscreen-compatible, real-time electrochemical sensing of SARS-CoV-2");
        assertThat(projectDetails.prefTerms()).isEqualTo("2019-nCoV;Affinity;Air;Antibodies;Binding;Binding Proteins;Biosensing Techniques;Biosensor;COVID-19;COVID-19 detection;COVID-19 pandemic;COVID-19 patient;Car Phone;Cellular Phone;Cessation of life;Chemistry;Clinical;Contact Tracing;Coronavirus;Detection;Development;Devices;Disease Outbreaks;Early Diagnosis;Electric Capacitance;Electrodes;Electronics;Engineering;Evaluation;Exhibits;Face;Frequencies;Future;Glass;Goals;Hospitals;Immobilization;Individual;Infection;Label;Libraries;Measures;Middle East Respiratory Syndrome;Molecular Conformation;Natural regeneration;Oxidation-Reduction;Pathogen detection;Pattern;Performance;Preparation;Process;Reporting;Restaurants;SARS coronavirus;SARS-CoV-2 spike protein;SARS-CoV-2 transmission;Sampling;Sensitivity and Specificity;Signal Transduction;Specificity;Surface;System;Technology;Testing;Time;Touch sensation;Vaccines;Validation;Virion;Work;aptamer;base;cost;density;design;infection rate;instrumentation;nanofabrication;new technology;novel;prevent;secondary infection;sensor;touchscreen;transmission process;viral detection;viral transmission");
    }

    @Test
    void shouldSplitPrefTerms() {
        var projectDetails = new ProjectDetails("", new ProjectNumberSplit("", "", "", "", "", "", ""), "", List.of(), Instant.now(), Instant.now(), "", "Term A;Term B", new OrganizationDetails(""));
        var prefTerms = projectDetails.getPrefTerms();
        assertThat(prefTerms).contains("Term A", "Term B");
    }
}
