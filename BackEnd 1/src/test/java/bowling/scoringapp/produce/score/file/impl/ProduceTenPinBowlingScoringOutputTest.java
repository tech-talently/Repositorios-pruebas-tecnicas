package bowling.scoringapp.produce.score.file.impl;

import bowling.scoringapp.dtos.FrameData;
import bowling.scoringapp.generate.score.api.IGenerateScoring;
import bowling.scoringapp.generate.score.impl.GenerateTenPinBowlScoring;
import bowling.scoringapp.produce.score.file.api.IProduceScoringOutput;
import bowling.scoringapp.transform.input.api.ITransformInput;
import bowling.scoringapp.transform.input.impl.TransformTenPinBowlFile;
import bowling.utils.api.IDataTransformation;
import bowling.utils.api.IDataValidation;
import bowling.utils.impl.DataTransformation;
import bowling.utils.impl.DataValidation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProduceTenPinBowlingScoringOutputTest {

    @Before
    public void setUpStreams() {
    }

    @Test
    public void produceScoringFile() {
        String[] contents = {"Jeff\t10", "John\t3", "John\t7", "Jeff\t7", "Jeff\t3", "John\t6", "John\t3", "Jeff\t9", "Jeff\t0",
                "John\t10", "Jeff\t10", "John\t8", "John\t1", "Jeff\t0", "Jeff\t8", "John\t10", "Jeff\t8", "Jeff\t2",
                "John\t10", "Jeff\tF", "Jeff\t6", "John\t9", "John\t0", "Jeff\t10", "John\t7", "John\t3", "Jeff\t10",
                "John\t4", "John\t4", "Jeff\t10", "Jeff\t8", "Jeff\t1", "John\t10", "John\t9", "John\t0"};
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ITransformInput transformInput = new TransformTenPinBowlFile(dataTransformation, dataValidation);
        FrameData[][] allFrames = transformInput.transformInputByFrameByPlayer(contents);
        IGenerateScoring produceScoring = new GenerateTenPinBowlScoring(dataValidation);
        allFrames = produceScoring.calculateScores(allFrames);
        IProduceScoringOutput produceFile = new ProduceTenPinBowlingScoringOutput();
        String[] outputLines = produceFile.produceScoringOutput(allFrames);
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