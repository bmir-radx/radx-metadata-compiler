{
    "@context": {
        "Data File Titles": "http://purl.org/radx-terms/metadata-terms/titleDescriptor",
        "Data File Identity": "http://purl.org/radx-terms/metadata-terms/identityDescriptor",
        "Data File Language": "http://purl.org/radx-terms/metadata-terms/languageDescriptor",
        "Data File Subjects": "http://purl.org/radx-terms/metadata-terms/subjectsAndKeywordsDescriptor",
        "Data File Descriptions": "http://purl.org/radx-terms/metadata-terms/descriptionDescriptor",
        "Data File Data Dictionary": "http://purl.org/radx-terms/metadata-terms/dataDictionaryDescriptor",
        "Data File Creators": "http://purl.org/radx-terms/metadata-terms/creatorDescriptor",
        "Data File Related Resources": "http://purl.org/radx-terms/metadata-terms/relatedResourceDescriptor",
        "Data File Contributors": "http://purl.org/radx-terms/metadata-terms/contributorDescriptor",
        "Data File Rights": "http://purl.org/radx-terms/metadata-terms/rightsDescriptor",
        "Data File Dates": "http://purl.org/radx-terms/metadata-terms/eventsDescriptor",
        "Data File Parent Studies": "http://purl.org/radx-terms/metadata-terms/parentStudyDescriptor",
        "Data File Funding Sources": "http://purl.org/radx-terms/metadata-terms/fundingSourceDescriptor",
        "Data File Distributions": "http://purl.org/radx-terms/metadata-terms/distributionDescriptor",
        "Data Characteristics Summary": "http://purl.org/radx-terms/metadata-terms/dataCharacteristicsDescriptor",
        "Data Sources": "http://purl.org/radx-terms/metadata-terms/dataSourceDescriptor",
        "Data Streams": "http://purl.org/radx-terms/metadata-terms/dataStreamDescriptor",
        "Data File Creation Processes": "http://purl.org/radx-terms/metadata-terms/dataFileCreationProcessDescriptor",
        "Data File Temporal Coverage": "http://purl.org/radx-terms/metadata-terms/temporalCoverageDescriptor",
        "Data File Spatial Coverage": "http://purl.org/radx-terms/metadata-terms/spatialCoverageDescriptor",
        "Data File Elevation Coverage": "http://purl.org/radx-terms/metadata-terms/elevationCoverageDescriptor",
        "Auxiliary Metadata": "http://purl.org/radx-terms/metadata-terms/auxiliaryMetadataDescriptor",
        "schema": "http://schema.org/",
        "xsd": "http://www.w3.org/2001/XMLSchema#",
        "pav:createdOn": {
            "@type": "xsd:dateTime"
        },
        "skos": "http://www.w3.org/2004/02/skos/core#",
        "rdfs": "http://www.w3.org/2000/01/rdf-schema#",
        "pav:createdBy": {
            "@type": "@id"
        },
        "rdfs:label": {
            "@type": "xsd:string"
        },
        "oslc:modifiedBy": {
            "@type": "@id"
        },
        "skos:notation": {
            "@type": "xsd:string"
        },
        "schema:isBasedOn": {
            "@type": "@id"
        },
        "schema:description": {
            "@type": "xsd:string"
        },
        "pav:lastUpdatedOn": {
            "@type": "xsd:dateTime"
        },
        "schema:name": {
            "@type": "xsd:string"
        },
        "pav:derivedFrom": {
            "@type": "@id"
        }
    },
    "@id": "https://repo.metadatacenter.org/template-instances/${uuid}",
    "schema:name": "Metadata ${(datafile_names.Value)!}",
    "schema:description": "Automatically generated from RADx-rad metadata",
    "schema:isBasedOn": "https://repo.metadatacenter.org/templates/c691629c-1183-4425-9a12-26201eab1a10",
    "pav:createdOn": null,
    "pav:createdBy": null,
    "pav:lastUpdatedOn": null,
    "oslc:modifiedBy": null,
    "Data File Titles": [
        {
            "@context": {
                "Title": "http://purl.org/radx-terms/metadata-terms/title",
                "Language": "http://purl.org/radx-terms/metadata-terms/language"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
            "Title": {
                "@value": "${(datafile_names.Qualifier)!}"
            },
            "Language": {
                "@value": "en"
            }
        }
    ],
    "Data File Identity": {
        "@context": {
            "Identifier": "http://purl.org/radx-terms/metadata-terms/identifier",
            "Identifier Type": "http://purl.org/radx-terms/metadata-terms/identifierType",
            "File Name": "http://purl.org/radx-terms/metadata-terms/fileName",
            "Version": "http://purl.org/radx-terms/metadata-terms/version",
            "SHA256 digest": "https://purl.org/radx-terms/sha256"
        },
        "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
        "Identifier": {
            "@value": null
        },
        "Identifier Type": {},
        "File Name": {
            "@value": "${(datafile_names.Value)!}"
        },
        "Version": {
            "@value": null
        },
        "SHA256 digest": {
            "@value": null
        }
    },
    "Data File Language": {
        "@context": {
            "Primary Language": "http://purl.org/radx-terms/metadata-terms/primaryLanguage",
            "Other Languages": "http://purl.org/radx-terms/metadata-terms/otherLanguage"
        },
        "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
        "Primary Language": {
            "@value": "en"
        },
        "Other Languages": [{}]
    },
    "Data File Subjects": [
        <#if project_research_area?has_content>
            {
            "@context": {
            "Subject Identifier": "http://purl.org/radx-terms/metadata-terms/subjectIdentifier",
            "Subject Identifier Scheme": "http://purl.org/radx-terms/metadata-terms/subjectIdentifierScheme",
            "Keyword": "http://purl.org/radx-terms/metadata-terms/keyword"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/15194e91-23ae-466b-8c47-707a428b6716",
            "Subject Identifier": {},
            "Subject Identifier Scheme": {
            "@value": null
            },
            "Keyword": {
            "@value": "${project_research_area.Value}"
            }
            }
            ,
        </#if>
        <#if keywords??>
            <#list keywords as kw> {
            "@context": {
                "Subject Identifier": "http://purl.org/radx-terms/metadata-terms/subjectIdentifier",
                "Subject Identifier Scheme": "http://purl.org/radx-terms/metadata-terms/subjectIdentifierScheme",
                "Keyword": "http://purl.org/radx-terms/metadata-terms/keyword"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/15194e91-23ae-466b-8c47-707a428b6716",
            "Subject Identifier": {},
            "Subject Identifier Scheme": {
                "@value": null
            },
            "Keyword": {
                "@value": "${kw.Value}"
            }
        }<#sep>,</#sep>
        </#list>
            <#else>
            {
                "@context": {
                "Subject Identifier": "http://purl.org/radx-terms/metadata-terms/subjectIdentifier",
                "Subject Identifier Scheme": "http://purl.org/radx-terms/metadata-terms/subjectIdentifierScheme",
                "Keyword": "http://purl.org/radx-terms/metadata-terms/keyword"
                },
                "@id": "https://repo.metadatacenter.org/template-element-instances/15194e91-23ae-466b-8c47-707a428b6716",
                "Subject Identifier": {},
                "Subject Identifier Scheme": {
                "@value": null
                },
                "Keyword": {
                "@value": null
                }
            }
        </#if>
    ],
    "Data File Descriptions": [
        {
            "@context": {
                "Description": "http://purl.org/radx-terms/metadata-terms/description",
                "Description Language": "http://purl.org/radx-terms/metadata-terms/language",
                "Type Of Content": "http://purl.org/radx-terms/metadata-terms/typeOfContent"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/cdc10ebd-4e28-4984-80a1-6cafd0c02a32",
            "Description": {
                "@value": null
            },
            "Description Language": {
                "@value": "en"
            },
            "Type Of Content": {
                "rdfs:label": "Dataset",
                "@id": "http://vocab.fairdatacollective.org/gdmt/Dataset"
            }
        }
    ],
    "Data File Data Dictionary": {
        "@context": {
            "Data Dictionary File Name": "http://purl.org/radx-terms/metadata-terms/dataDictionaryFileName"
        },
        "@id": "https://repo.metadatacenter.org/template-element-instances/0b70a6e9-b87c-4722-a694-2f1790c20d83",
        "Data Dictionary File Name": {
            "@value": "${(name_of_data_dictionary_file.Value)!}"
        }
    },
    "Data File Creators": [
        <#if creator??>
            <#list creator as c>

                {
                "@context": {
                "Creator Type": "http://purl.org/radx-terms/metadata-terms/creatorType",
                "Creator Name": "http://purl.org/radx-terms/metadata-terms/creatorName",
                "Creator Given Name": "http://purl.org/radx-terms/metadata-terms/creatorGivenName",
                "Creator Family Name": "http://purl.org/radx-terms/metadata-terms/creatorFamilyName",
                "Creator Identifier": "http://purl.org/radx-terms/metadata-terms/creatorIdentifier",
                "Creator Identifier Scheme": "http://purl.org/radx-terms/metadata-terms/creatorIdentifierScheme",
                "Creator Email": "http://purl.org/radx-terms/metadata-terms/creatorEmail",
                "Creator Affiliation": "http://purl.org/radx-terms/metadata-terms/creatorAffiliation",
                "Creator Affiliation Identifier": "http://purl.org/radx-terms/metadata-terms/creatorAffiliationIdentifier",
                "Creator Affiliation Identifier Scheme": "http://purl.org/radx-terms/metadata-terms/creatorAffiliationIdentifierScheme",
                "Creator Role": "http://purl.org/radx-terms/metadata-terms/creatorRole"
                },
                "@id": "https://repo.metadatacenter.org/template-element-instances/775d158c-421f-4b15-addc-fc67eacc4ce5",
                "Creator Type": {
                "rdfs:label": "Person",
                "@id": "http://vocab.fairdatacollective.org/gdmt/Person"
                },
                "Creator Name": {
                "@value": "${c.Value}?"
                },
                <#assign res = "${c.Value}"?matches(r"(\w+) (\w+)")>

                "Creator Given Name": {
                <#if res>
                    "@value" : "${res?groups[1]}"
                <#else>
                    "@value" : null
                </#if>
                },
                "Creator Family Name": {
                <#if res>
                    "@value" : "${res?groups[2]}"
                <#else>
                    "@value" : null
                </#if>
                },
                "Creator Identifier": {
                "@value": "${(c.Qualifier)!}"
                },
                "Creator Identifier Scheme": {
                <#if c.Qualifier??>
                    <#if c.Qualifier?contains("https://orcid.org")>
                        "rdfs:label": "ORCID",
                        "@id": "https://orcid.org/"
                    </#if>
                    <#if c.Qualifier?contains("https://www.linkedin.com")>
                        "rdfs:label": "LinkedIn",
                        "@id": "https://www.linkedin.com/"
                    </#if>
                </#if>
                },
                "Creator Email": {
                "@value": null
                },
                "Creator Affiliation": {
                "@value": "${(source_organization.Value)!}"
                },
                "Creator Affiliation Identifier": {
                "@value": "${(source_organization.Qualifier)!}"
                },
                "Creator Affiliation Identifier Scheme": {
                "rdfs:label": "ROR",
                "@id": "https://ror.org"
                },
                "Creator Role": {}
                }<#sep>,</#sep>


            </#list>
        </#if>
    ],
    "Data File Related Resources": [
        <#if publication_url??>
            <#list publication_url as pub>
            {
            "@context": {
            "Related Resource Identifier": "http://purl.org/radx-terms/metadata-terms/relatedResourceIdentifier",
            "Related Resource Identifier Type": "http://purl.org/radx-terms/metadata-terms/relatedResourceIdentifierType",
            "Related Resource File Name": "http://purl.org/radx-terms/metadata-terms/relatedResourceFileName",
            "Related Resource Type Category": "http://purl.org/radx-terms/metadata-terms/relatedResourceTypeCategory",
            "Related Resource Relation": "http://purl.org/radx-terms/metadata-terms/relatedResourceRelation"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/3b24b191-518c-4257-9934-c488fc1887e8",
            "Related Resource Identifier": {
            "@value": "${pub.Value}"
            },
            "Related Resource Identifier Type": {
            "rdfs:label": "URL",
            "@id" : "http://vocab.fairdatacollective.org/gdmt/URL"
            },
            "Related Resource File Name": {},
            "Related Resource Type Category": {},
            "Related Resource Relation": {}
            }<#sep>,</#sep>
        </#list>
        <#else>
            {
            "@context": {
            "Related Resource Identifier": "http://purl.org/radx-terms/metadata-terms/relatedResourceIdentifier",
            "Related Resource Identifier Type": "http://purl.org/radx-terms/metadata-terms/relatedResourceIdentifierType",
            "Related Resource File Name": "http://purl.org/radx-terms/metadata-terms/relatedResourceFileName",
            "Related Resource Type Category": "http://purl.org/radx-terms/metadata-terms/relatedResourceTypeCategory",
            "Related Resource Relation": "http://purl.org/radx-terms/metadata-terms/relatedResourceRelation"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/3b24b191-518c-4257-9934-c488fc1887e8",
            "Related Resource Identifier": {
            "@value": null
            },
            "Related Resource Identifier Type": {},
            "Related Resource File Name": {},
            "Related Resource Type Category": {},
            "Related Resource Relation": {}
            }
        </#if>
    ],
    "Data File Contributors": [
        <#list contact_PI as c>
            {
            "@context": {
                "Contributor Type": "http://purl.org/radx-terms/metadata-terms/contributorType",
                "Contributor Name": "http://purl.org/radx-terms/metadata-terms/contributorName",
                "Contributor Given Name": "http://purl.org/radx-terms/metadata-terms/contributorGivenName",
                "Contributor Family Name": "http://purl.org/radx-terms/metadata-terms/contributorFamilyName",
                "Contributor Identifier": "http://purl.org/radx-terms/metadata-terms/contributorIdentifier",
                "Contributor Identifier Scheme": "http://purl.org/radx-terms/metadata-terms/contributorIdentifierScheme",
                "Contributor Affiliation": "http://purl.org/radx-terms/metadata-terms/contributorAffiliation",
                "Contributor Affiliation Identifier": "http://purl.org/radx-terms/metadata-terms/contributorAffiliationIdentifier",
                "Contributor Affiliation Identifier Scheme": "http://purl.org/radx-terms/metadata-terms/contributorAffiliationIdentifierScheme",
                "Contributor Email": "http://purl.org/radx-terms/metadata-terms/contributorEmail",
                "Contributor Role": "http://purl.org/radx-terms/metadata-terms/contributorRole"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/fd1d8354-b468-4ee8-9a25-faa9ea293c28",
            "Contributor Type": {
                "rdfs:label": "Person",
                "@id": "http://vocab.fairdatacollective.org/gdmt/Person"
            },
            "Contributor Name": {
                "@value": "${c.Value}"
            },
            <#assign res = "${c.Value}"?matches(r"(\w+) (\w+)")>

            "Contributor Given Name": {
            <#if res>
                "@value" : "${res?groups[1]}"
            <#else>
                "@value" : null
            </#if>
            },
            "Contributor Family Name": {
            <#if res>
                "@value" : "${res?groups[2]}"
            <#else>
                "@value" : null
            </#if>
            },
            "Contributor Identifier": {
                "@value": "${(c.Qualifier)!}"
            },
            "Contributor Identifier Scheme": {
            <#if c.Qualifier??>
                <#if c.Qualifier?contains("https://orcid.org")>
                    "rdfs:label": "ORCID",
                    "@id": "https://orcid.org/"
                </#if>
                <#if c.Qualifier?contains("https://www.linkedin.com")>
                    "rdfs:label": "LinkedIn",
                    "@id": "https://www.linkedin.com/"
                </#if>
            </#if>
            },
            "Contributor Affiliation": {
                "@value": "${(source_organization.Value)!}"
            },
            "Contributor Affiliation Identifier": {
                "@value": "${(source_organization.Qualifier)!}"
            },
            "Contributor Affiliation Identifier Scheme": {
                "rdfs:label": "ROR",
                "@id": "https://ror.org"
            },
            "Contributor Email": {
                "@value": null
            },
            "Contributor Role": {
                "rdfs:label" : "Project Leader",
                "@id" : "http://vocab.fairdatacollective.org/gdmt/ProjectLeader"
            }
        }
            <#sep>,</#sep>
        </#list>
    ],
    "Data File Rights": [
        {
            "@context": {
                "License Name": "http://purl.org/radx-terms/metadata-terms/licenseName",
                "License Text": "http://purl.org/radx-terms/metadata-terms/licenseText"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/ddd9630e-c072-4928-80ef-3cae9bb3312b",
            "License Name": {},
            "License Text": {
                "@value": null
            }
        }
    ],
    "Data File Dates": [
        {
            "@context": {
                "Event Type": "http://purl.org/radx-terms/metadata-terms/eventType",
                "Date": "http://purl.org/radx-terms/metadata-terms/eventDate"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/6bbe1c7e-b263-4767-bfda-840539e62b57",
            "Event Type": { },
            "Date": {
                "@type": "xsd:dateTime",
                "@value": null
            }
        }
    ],
    "Data File Parent Studies": [
        {
            "@context": {
                "PHS Identifier": "http://purl.org/radx-terms/metadata-terms/parentStudyPhsIdentifier",
                "Study Identifier": "http://purl.org/radx-terms/metadata-terms/ParentStudyIdentifier",
                "Study Identifier Scheme": "http://purl.org/radx-terms/metadata-terms/parentStudyIdentifierScheme",
                "Study Name": "http://purl.org/radx-terms/metadata-terms/parentStudyName",
                "Study Start Date": "http://purl.org/radx-terms/metadata-terms/startDate",
                "Study End Date": "http://purl.org/radx-terms/metadata-terms/endDate"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
            "PHS Identifier": {
                "@value": "${(PHS_ID.Value)!}"
            },
            "Study Identifier": {
                "@value": "https://reporter.nih.gov/project-details/${(NIH_project_ID.Value)!}"
            },
            "Study Identifier Scheme": {
                "rdfs:label": "IRI",
                "@id": "http://vocab.fairdatacollective.org/gdmt/IRI"
            },
            "Study Name": {
                "@value": "${(project_title.Value)!}"
            },
            "Study Start Date": {
                "@type": "xsd:dateTime",
                "@value": null
            },
            "Study End Date": {
                "@type": "xsd:dateTime",
                "@value": null
            }
        }
    ],
    "Data File Funding Sources": [
        {
            "@context": {
                "Award Title": "http://purl.org/radx-terms/metadata-terms/awardTitle",
                "Award Page URL": "http://purl.org/radx-terms/metadata-terms/awardPageUrl",
                "Award Local Identifier": "http://purl.org/radx-terms/metadata-terms/awardIdentifier",
                "Funder Name": "http://purl.org/radx-terms/metadata-terms/funderName",
                "Funder Identifier": "http://purl.org/radx-terms/metadata-terms/funderIdentifier",
                "Funder Identifier Scheme": "http://purl.org/radx-terms/metadata-terms/funderIdentifierScheme"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
            "Award Title": {
                "@value": "${(project_title.Value)!}"
            },
            "Award Page URL": {
                "@id": "https://reporter.nih.gov/project-details/${(NIH_project_ID.Value)!}"
            },
            "Award Local Identifier": {
                "@value": "${(NIH_project_ID.Value)!}"
            },
            "Funder Name": {
                "@value": null
            },
            "Funder Identifier": {
                "@value": null
            },
            "Funder Identifier Scheme": { }
        }
    ],
    "Data File Distributions": [
        {
            "@context": {
                "Distribution Publisher": "http://purl.org/radx-terms/metadata-terms/distributionPublisher",
                "Distribution Publisher Identifier": "http://purl.org/radx-terms/metadata-terms/distributionPublisherIdentifier",
                "Distribution Publisher Identifier Scheme": "http://purl.org/radx-terms/metadata-terms/distributionPublisherIdentifierScheme",
                "Distribution Identifier": "http://purl.org/radx-terms/metadata-terms/distributionIdentifier",
                "Distribution Identifier Type": "http://purl.org/radx-terms/metadata-terms/distributionIdentifierType",
                "Distribution Format": "http://purl.org/radx-terms/metadata-terms/distributionFormat",
                "Distribution Media Type": "http://purl.org/radx-terms/metadata-terms/distributionMediaType",
                "Distribution Size": "http://purl.org/radx-terms/metadata-terms/distributionSizeInBytes",
                "Distribution Access Protocol": "http://purl.org/radx-terms/metadata-terms/distributionAccessProtocol",
                "Distribution Access Configuration": "http://purl.org/radx-terms/metadata-terms/distributionAccessConfiguration",
                "Distribution Query Statement": "http://purl.org/radx-terms/metadata-terms/distributionQueryStatement",
                "Data File Publication Date": "http://purl.org/radx-terms/metadata-terms/distributionPublicationDescriptor"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
            "Distribution Publisher": {
                "@value": null
            },
            "Distribution Publisher Identifier": {
                "rdfs:label": ""
            },
            "Distribution Publisher Identifier Scheme": {
                "rdfs:label": ""
            },
            "Distribution Identifier": {
                "@value": null
            },
            "Distribution Identifier Type": {
                "rdfs:label": ""
            },
            "Distribution Format": {
                "@value": null
            },
            "Distribution Media Type": {
                "rdfs:label": ""
            },
            "Distribution Size": {
                "@value": null
            },
            "Distribution Access Protocol": {
                "@value": null
            },
            "Distribution Access Configuration": {
                "@value": null
            },
            "Distribution Query Statement": {
                "@value": null
            },
            "Data File Publication Date": {
                "@context": {
                    "Data File Publication Date": "http://purl.org/radx-terms/metadata-terms/distributionPublicationDate",
                    "Publication Date Type": "http://purl.org/radx-terms/metadata-terms/distributionPublicationDateType"
                },
                "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
                "Data File Publication Date": {
                    "@type": "xsd:dateTime",
                    "@value": null
                },
                "Publication Date Type": {
                    "@value": null
                }
            }
        }
    ],
    "Data Characteristics Summary": {
        "@context": {
            "Data Characteristics Table in HTML": "http://purl.org/radx-terms/metadata-terms/dataCharacteristicsTableInHtml",
            "Data Characteristics Table in CSV": "http://purl.org/radx-terms/metadata-terms/dataCharacteristicsTableInCsv",
            "Data Characteristics Table in TSV": "http://purl.org/radx-terms/metadata-terms/dataCharacteristicsTableInTsv",
            "Data Characteristics Table in Key-Value Pairs": "http://purl.org/radx-terms/metadata-terms/dataCharacteristicsTableInKeyValuePairs"
        },
        "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
        "Data Characteristics Table in HTML": {
            "@value": null
        },
        "Data Characteristics Table in CSV": {
            "@value": null
        },
        "Data Characteristics Table in TSV": {
            "@value": null
        },
        "Data Characteristics Table in Key-Value Pairs": [
            ""
        ]
    },
    "Data Sources": [
        {
            "@context": {
                "Data Source Name": "http://purl.org/radx-terms/metadata-terms/dataSourceName",
                "Data Source Identifier": "http://purl.org/radx-terms/metadata-terms/dataSourceIdentifier",
                "Data Source Identifier Scheme": "http://purl.org/radx-terms/metadata-terms/dataSourceIdentifierScheme"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
            "Data Source Name": {
                "@value": null
            },
            "Data Source Identifier": {
                "@value": null
            },
            "Data Source Identifier Scheme": {
                "rdfs:label": ""
            }
        }
    ],
    "Data Streams": [
        {
            "@context": {
                "Data Stream Name": "http://purl.org/radx-terms/metadata-terms/dataStreamName",
                "Data Stream Identifier": "http://purl.org/radx-terms/metadata-terms/dataStreamIdentifier",
                "Data Stream Identifier Scheme": "http://purl.org/radx-terms/metadata-terms/dataStreamIdentifierScheme",
                "Data Stream Variable Names": "http://purl.org/radx-terms/metadata-terms/dataStreamVariableName",
                "Data Stream Data Source Identifier": "http://purl.org/radx-terms/metadata-terms/dataStreamDataSourceIdentifier"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
            "Data Stream Name": {
                "@value": null
            },
            "Data Stream Identifier": {
                "@value": null
            },
            "Data Stream Identifier Scheme": {
                "rdfs:label": ""
            },
            "Data Stream Variable Names": [
                {
                    "@value": null
                }
            ],
            "Data Stream Data Source Identifier": {
                "@value": null
            }
        }
    ],
    "Data File Creation Processes": [
        {
            "@context": {
                "Process Name": "http://purl.org/radx-terms/metadata-terms/creationProcessName",
                "Process IRI": "http://purl.org/radx-terms/metadata-terms/creationProcessIri",
                "Process Version": "http://purl.org/radx-terms/metadata-terms/creationProcessVersion",
                "Process Execution Identifier": "http://purl.org/radx-terms/metadata-terms/creationProcessExecutionIdentifier"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
            "Process Name": {
                "@value": null
            },
            "Process IRI": {
                "@value": null
            },
            "Process Version": {
                "@value": null
            },
            "Process Execution Identifier": {
                "@value": null
            }
        }
    ],
    "Data File Temporal Coverage": [
        {
            "@context": {
                "Temporal Extent Minimum Value": "http://purl.org/radx-terms/metadata-terms/temporalExtentMinimumValue",
                "Temporal Extent Maximum Value": "http://purl.org/radx-terms/metadata-terms/temporalExtentMaximumValue",
                "Temporal Resolution": "http://purl.org/radx-terms/metadata-terms/temporalResolution",
                "Duration": "http://purl.org/radx-terms/metadata-terms/temporalCoverageDuration"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
            "Temporal Extent Minimum Value": {
                "@type": "xsd:dateTime",
                "@value": null
            },
            "Temporal Extent Maximum Value": {
                "@type": "xsd:dateTime",
                "@value": null
            },
            "Temporal Resolution": {
                "@value": null
            },
            "Duration": {
                "@value": null
            }
        }
    ],
    "Data File Spatial Coverage": [
        {
            "@context": {
                "Bounding Boxes": "http://purl.org/radx-terms/metadata-terms/boundingBoxDescriptor",
                "Bounding Shapes": "http://purl.org/radx-terms/metadata-terms/boundingShapeDescriptor",
                "Data File Geopolitical Coverage": "http://purl.org/radx-terms/metadata-terms/geopoliticalCoverageDescriptor"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
            "Bounding Boxes": [{
                "@context": {
                "Maximum Latitude": "http://purl.org/radx-terms/metadata-terms/maxLatitude",
                "Minimum Latitude": "http://purl.org/radx-terms/metadata-terms/minLatitude",
                "Minimum Longitude": "http://purl.org/radx-terms/metadata-terms/minLongitude",
                "Maximum Longitude": "http://purl.org/radx-terms/metadata-terms/maxLongitude"
              },
              "@id" : "https://repo.metadatacenter.org/template-element-instances/${uuid}",
              "Maximum Latitude": {
                "@value": null
              },
              "Minimum Latitude": {
                "@value": null
              },
              "Minimum Longitude": {
                "@value": null
              },
              "Maximum Longitude": {
                "@value": null
              }
            }],
            "Bounding Shapes": [{
                 "@context": {
                "Point Number": "http://purl.org/radx-terms/metadata-terms/pointNumber",
                "Latitude": "http://purl.org/radx-terms/metadata-terms/latitude",
                "Longitude": "http://purl.org/radx-terms/metadata-terms/longitude"
              },
              "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
              "Point Number": {
                "@type": "xsd:decimal",
                "@value": null
              },
              "Latitude": {
                "@type": "xsd:decimal",
                "@value": null
              },
              "Longitude": {
                "@type": "xsd:decimal",
                "@value": null
              }
             }],
            "Data File Geopolitical Coverage": [{
                "@context": {
                    "Geopolitical region ": "http://purl.org/radx-terms/metadata-terms/geographicalPlaceName"
                  },
                  "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
                  "Geopolitical region ": [
                    {
                      "@value": null
                    }
                  ]
            }]
        }
    ],
    "Data File Elevation Coverage": [
        {
            "@context": {
                "Vertical Extent Minimum Value": "http://purl.org/radx-terms/metadata-terms/minElevation",
                "Vertical Extent Maximum Value": "http://purl.org/radx-terms/metadata-terms/maxElevation",
                "Vertical Extent Datum": "http://purl.org/radx-terms/metadata-terms/elevationReferenceFrame",
                "Vertical Extent Datum IRI": "http://purl.org/radx-terms/metadata-terms/elevationReferenceFrameIri"
            },
            "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
            "Vertical Extent Minimum Value": {
                "@type": "xsd:decimal",
                "@value": null
            },
            "Vertical Extent Maximum Value": {
                "@type": "xsd:decimal",
                "@value": null
            },
            "Vertical Extent Datum": {
                "@value": null
            },
            "Vertical Extent Datum IRI": {
            }
        }
    ],
    "Auxiliary Metadata": {
        "@context": {
            "Data File Descriptive Key-Value Pairs": "http://purl.org/radx-terms/metadata-terms/auxiliaryMetadataKeyValuePair",
            "Additional Commentary": "http://purl.org/radx-terms/metadata-terms/auxiliaryMetadataCommentary"
        },
        "@id": "https://repo.metadatacenter.org/template-element-instances/${uuid}",
        "Data File Descriptive Key-Value Pairs": [
            "type_of_sample_used",
            "method_of_data_analysis",
            "NIH_PO_approved_waiver_for_Minimum_CDE",
            "study_include_prospective_or_retrospective_human_samples"
        ],
        "Additional Commentary": [
            {
                "@value": null
            }
        ],
        "type_of_sample_used": {
            "@value": "${(type_of_sample_used.Value)!}"
        },
        "method_of_data_analysis": {
            "@value": "${(method_of_data_analysis.Value)!""}"
        },
        "NIH_PO_approved_waiver_for_Minimum_CDE" : {
            "@value" : "${(NIH_PO_approved_waiver_for_Minimum_CDE.Value)!}"
        },
        "description_of_project" : {
            "@value" : "${(project_description.Value)!}"
        },
        "study_include_prospective_or_retrospective_human_samples" : {
            "@value" : "${(study_include_prospective_or_retrospective_human_samples.Value)!}"
        }
    }
}