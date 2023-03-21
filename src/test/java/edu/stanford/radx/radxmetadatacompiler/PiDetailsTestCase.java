package edu.stanford.radx.radxmetadatacompiler;

import edu.stanford.radx.radxmetadatacompiler.nihreporter.PiDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2022-12-10
 */
@SpringBootTest
@AutoConfigureJsonTesters
public class PiDetailsTestCase {

    @Autowired
    private JacksonTester<PiDetails> tester;

    @Test
    void shouldParsePiDetails() throws IOException {
        var json = """
                {
                                    "profile_id": 8012149,
                                    "first_name": "Suzie",
                                    "middle_name": "H.",
                                    "last_name": "Pun",
                                    "is_contact_pi": true,
                                    "full_name": "Suzie H. Pun",
                                    "title": "PROFESSOR"
               }
                """;

        var parsedContent = tester.parse(json);
        var parsedPiDetails = parsedContent.getObject();
        assertThat(parsedPiDetails.firstName()).isEqualTo("Suzie");
        assertThat(parsedPiDetails.lastName()).isEqualTo("Pun");
    }
}
