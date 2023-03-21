package edu.stanford.radx.radxmetadatacompiler.nihreporter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.Duration;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-10
 */
@Component
public class NiHReporterService {


    public NiHReporterService() {
    }

    public Optional<ProjectDetails> getProjectDetails(String projectNumber) {
        var body = new ProjectNumberSearch(projectNumber, 0, 1).getQuery();
        var webClient = WebClient.create("https://api.reporter.nih.gov");
        try {
            var result = webClient.method(HttpMethod.POST)
                            .uri("/v2/projects/search")
                            .bodyValue(body)
                            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                            .retrieve()
                            .bodyToMono(ProjectSearchResult.class)
                            .block(Duration.ofSeconds(10));
            return Optional.ofNullable(result)
                    .map(r -> result.results().stream())
                    .flatMap(Stream::findFirst);
        } catch (WebClientResponseException e) {
            if(e.getStatusCode().value() == 404) {
                return Optional.empty();
            }
            else {
                throw e;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }
}
