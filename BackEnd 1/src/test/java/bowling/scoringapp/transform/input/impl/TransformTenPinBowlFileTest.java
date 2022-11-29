package bowling.scoringapp.transform.input.impl;

import bowling.scoringapp.dtos.FrameData;
import bowling.scoringapp.transform.input.api.ITransformInput;
import bowling.utils.api.IDataTransformation;
import bowling.utils.api.IDataValidation;
import bowling.utils.impl.DataTransformation;
import bowling.utils.impl.DataValidation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TransformTenPinBowlFileTest {

    @Before
    public void setUp() {
    }

    @Test
    public void transformInputByFrameByPlayer() {
        String[] contents = {"Jeff\t10", "John\t3", "John\t7", "Jeff\t7", "Jeff\t3", "John\t6", "John\t3", "Jeff\t9", "Jeff\t0",
                "John\t10", "Jeff\t10", "John\t8", "John\t1", "Jeff\t0", "Jeff\t8", "John\t10", "Jeff\t8", "Jeff\t2",
                "John\t10", "Jeff\tF", "Jeff\t6", "John\t9", "John\t0", "Jeff\t10", "John\t7", "John\t3", "Jeff\t10",
                "John\t4", "John\t4", "Jeff\t8", "Jeff\t2", "Jeff\t8", "John\t10", "John\t9", "John\t0"};
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ITransformInput transformInput = new TransformTenPinBowlFile(dataTransformation, dataValidation);
        FrameData[][] allFrames = transformInput.transformInputByFrameByPlayer(contents);
        Assert.assertEquals(2, allFrames.length);
        Assert.assertEquals(10, allFrames[0].length);
        Assert.assertEquals(10, allFrames[1].length);
        Assert.assertEquals(Arrays.asList("8", "2", "8"), allFrames[0][9].getResults().getPinFalls());
        Assert.assertEquals(Arrays.asList("10", "9", "0"), allFrames[1][9].getResults().getPinFalls());
//        System.out.println(Arrays.toString(allFrames));
//        for (int i = 0; i < allFrames.length; i++) {
//            for (int j = 0; j < allFrames[i].length; j++) {
//                System.out.println("FRAME - frame: " + allFrames[i][j].getFrame());
//                System.out.print("FRAME - results: ");
//                Results results = allFrames[i][j].getResults();
//                System.out.print(allFrames[i][j].getPlayer() + " result: " + allFrames[i][j].getResults().getPinFalls() + " mark:" + allFrames[i][j].getResults().getMark());
//                System.out.println("");
//            }
//        }
    }
}