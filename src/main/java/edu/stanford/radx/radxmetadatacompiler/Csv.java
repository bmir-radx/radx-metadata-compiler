package edu.stanford.radx.radxmetadatacompiler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-14
 */
public record Csv(List<String> header,
                  List<List<String>> content) {

    public Csv(List<String> header, List<List<String>> content) {
        this.header = List.copyOf(header);
        this.content = List.copyOf(content);
    }
}
