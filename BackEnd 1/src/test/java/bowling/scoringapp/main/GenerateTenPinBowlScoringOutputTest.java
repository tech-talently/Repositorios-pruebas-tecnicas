package bowling.scoringapp.main;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GenerateTenPinBowlScoringOutputTest {

    @Before
    public void setUp() {
    }

    @Test
    public void readFileContents() {
        File file = new File("src/test/resources/sample1.txt");
        String fileContent = readFromInputStream(file);
        Assert.assertFalse(StringUtils.isBlank(fileContent));
    }

    protected String readFromInputStream(File file) {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.toString();
    }
}