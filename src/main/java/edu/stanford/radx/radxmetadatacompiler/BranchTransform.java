package edu.stanford.radx.radxmetadatacompiler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-14
 */
public class BranchTransform {

    public BranchTransform() {
    }

    public Map<String, Csv> transformCsv(Csv csv) {
        var result = new LinkedHashMap<String, Csv>();
        var matchedRows = csv.content()
                             .stream()
                             .filter(row -> row.get(0).equals("datafile_names"))
                             .toList();
        if(matchedRows.isEmpty()) {
            return Map.of("", csv);
        }
        for(var branchingRow : matchedRows) {
            var branchedContent = csv.content()
                                     .stream()
                                     .filter(row -> !matchedRows.contains(row) || row.equals(branchingRow))
                                     .toList();
            var branchNameIndex = 1;
            if(branchNameIndex < branchingRow.size()) {
                var branchName = branchingRow.get(branchNameIndex);
                if (!branchName.isBlank()) {
                    var branchedCsv = new Csv(csv.header(), branchedContent);
                    result.put(branchName, branchedCsv);
                }
            }
        }
        return result;
    }
}
