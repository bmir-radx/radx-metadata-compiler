package edu.stanford.radx.radxmetadatacompiler;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-14
 */
@Component
public class CsvLoader {

    public Csv loadCsv(Path path) throws IOException {
        var csvParser = new CSVParser(new FileReader(path.toFile()), CSVFormat.DEFAULT);
        var records = csvParser.getRecords();
        if(records.isEmpty()) {
            return new Csv(List.of(), List.of());
        }
        return new Csv(records.get(0).toList(),
                       records.stream().skip(1).map(CSVRecord::toList).toList());
    }
}
