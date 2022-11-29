package bowling.scoringapp.main;

import bowling.scoringapp.dtos.FrameData;
import bowling.utils.api.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.util.Arrays;

@Category(IntegrationTest.class)
public class GenerateScoringOutputIntegrationTest {
    @Before
    public void setUp() {

    }

    @Test
    public void produceScoringOutput() {
        File file = new File("src/test/resources/sample1.txt");
        String fileContent = new GenerateTenPinBowlScoringOutputTest().readFromInputStream(file);
        String[] contents = fileContent.split(Constants.FILE_DELIMITER);

        GenerateTenPinBowlScoringOutput generateScoringOutput = new GenerateTenPinBowlScoringOutput();
        generateScoringOutput.validateInputFile(contents);
        FrameData[][] allFrames = generateScoringOutput.produceScoring(contents);
        Assert.assertEquals(Arrays.asList("10", ""), allFrames[0][8].getResults().getPinFalls());
        Assert.assertEquals(Arrays.asList("4", "4"), allFrames[1][8].getResults().getPinFalls());
        Assert.assertEquals(167, allFrames[0][9].getResults().getScore().intValue());
        Assert.assertEquals(151, allFrames[1][9].getResults().getScore().intValue());
        String[] outputLines = generateScoringOutput.createScoringOutput(allFrames);
        String[] outputLinesExpected = {"Frame \t\t1 \t\t2 \t\t3 \t\t4 \t\t5 \t\t6 \t\t7 \t\t8 \t\t9 \t\t10",
                "Jeff",
                "Pinfalls\t \tX\t7\t/\t9\t0\t \tX\t0\t8\t8\t/\tF\t6\t \tX\t \tX\tX\t8\t1",
                "Score \t\t20\t\t39\t\t48\t\t66\t\t74\t\t84\t\t90\t\t120\t\t148\t\t167",
                "John",
                "Pinfalls\t3\t/\t6\t3\t \tX\t8\t1\t \tX\t \tX\t9\t0\t7\t/\t4\t4\tX\t9\t0",
                "Score \t\t16\t\t25\t\t44\t\t53\t\t82\t\t101\t\t110\t\t124\t\t132\t\t151"};
        for (int i = 0; i < outputLines.length; i++) {
            Assert.assertEquals(outputLines[i], outputLinesExpected[i]);
        }
    }
}
