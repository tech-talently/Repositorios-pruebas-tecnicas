package bowling.scoringapp.validate.input.impl;

import bowling.scoringapp.validate.input.api.ValidateInputFile;
import bowling.utils.api.Constants;
import bowling.utils.api.IDataTransformation;
import bowling.utils.api.IDataValidation;
import bowling.utils.api.IInputValidation;
import bowling.utils.impl.DataTransformation;
import bowling.utils.impl.DataValidation;
import bowling.utils.impl.InputValidation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ValidateInputTenPinBowlFileTest {

    @Before
    public void setUp() {
    }

    @Test
    // When turns are all 10 (strike and spare on last frame)
    public void validateTurnsCountPerPlayer1() {
        String[] contents = {"Jeff\t10", "John\t3", "John\t7", "Jeff\t7", "Jeff\t3", "John\t6", "John\t3", "Jeff\t9", "Jeff\t0",
                "John\t10", "Jeff\t10", "John\t8", "John\t1", "Jeff\t0", "Jeff\t8", "John\t10", "Jeff\t8", "Jeff\t2",
                "John\t10", "Jeff\tF", "Jeff\t6", "John\t9", "John\t0", "Jeff\t10", "John\t7", "John\t3", "Jeff\t10",
                "John\t4", "John\t4", "Jeff\t8", "Jeff\t2", "Jeff\t8", "John\t10", "John\t9", "John\t0"};
        IInputValidation inputValidation = new InputValidation();
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ValidateInputFile validate = new ValidateInputTenPinBowlFile(inputValidation, dataTransformation, dataValidation);
        validate.validateTurnsCountPerPlayer(contents);
        Map<String, Integer> playersTurns = validate.getPlayersTurns();
        for (Map.Entry<String, Integer> entry : playersTurns.entrySet()) {
            Assert.assertEquals(Constants.NUMBER_OF_FRAMES.intValue(), entry.getValue().intValue());
        }
    }

    @Test(expected = RuntimeException.class)
    // When turns are greater than 10
    public void validateTurnsCountPerPlayer2() {
        String[] contents = {"Jeff\t10", "John\t3", "John\t7", "Jeff\t7", "Jeff\t3", "John\t6", "John\t3", "Jeff\t9", "Jeff\t0",
                "John\t10", "Jeff\t10", "John\t8", "John\t1", "Jeff\t0", "Jeff\t8", "John\t10", "Jeff\t8", "Jeff\t2",
                "John\t10", "Jeff\tF", "Jeff\t6", "John\t9", "John\t0", "Jeff\t10", "John\t7", "John\t3", "Jeff\t10",
                "John\t4", "John\t4", "Jeff\t8", "Jeff\t2", "Jeff\t8", "Jeff\t8", "John\t10", "John\t9", "John\t0", "John\t2"};
        IInputValidation inputValidation = new InputValidation();
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ValidateInputFile validate = new ValidateInputTenPinBowlFile(inputValidation, dataTransformation, dataValidation);
        validate.validateTurnsCountPerPlayer(contents);
    }

    @Test(expected = RuntimeException.class)
    // When turns are lower than 10
    public void validateTurnsCountPerPlayer3() {
        String[] contents = {"Jeff\t10", "John\t3", "John\t7", "Jeff\t7", "Jeff\t3", "John\t6", "John\t3", "Jeff\t9", "Jeff\t0",
                "John\t10", "Jeff\t10", "John\t8", "John\t1", "Jeff\t0", "Jeff\t8", "John\t10", "Jeff\t8", "Jeff\t2",
                "John\t10", "Jeff\tF", "Jeff\t6", "John\t9", "John\t0", "Jeff\t10", "John\t7", "John\t3", "Jeff\t10",
                "John\t4", "John\t4", "Jeff\t8", "Jeff\t2", "John\t10", "John\t0"};
        IInputValidation inputValidation = new InputValidation();
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ValidateInputFile validate = new ValidateInputTenPinBowlFile(inputValidation, dataTransformation, dataValidation);
        validate.validateTurnsCountPerPlayer(contents);
    }

    @Test
    // When turns are 10 (normal throw on last frame)
    public void validateTurnsCountPerPlayer4() {
        String[] contents = {"Jeff\t0", "Jeff\t0", "Jeff\t0", "Jeff\t0", "Jeff\t0", "Jeff\t0", "Jeff\t0", "Jeff\t0",
                "Jeff\t0", "Jeff\t0", "Jeff\t0", "Jeff\t0", "Jeff\t0", "Jeff\t0", "Jeff\t0", "Jeff\t0",
                "Jeff\t0", "Jeff\t0", "Jeff\t2", "Jeff\t0",};
        IInputValidation inputValidation = new InputValidation();
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ValidateInputFile validate = new ValidateInputTenPinBowlFile(inputValidation, dataTransformation, dataValidation);
        validate.validateTurnsCountPerPlayer(contents);
    }

    @Test
    // When turns are 10 (all strikes on last frame)
    public void validateTurnsCountPerPlayer5() {
        String[] contents = {"Jeff\t10", "Jeff\t2", "Jeff\t6", "Jeff\t3", "Jeff\t7", "Jeff\t10", "Jeff\t10",
                "Jeff\t2", "Jeff\t6", "Jeff\t4", "Jeff\t5", "Jeff\t10", "Jeff\t10", "Jeff\t10", "Jeff\t10",
                "Jeff\t10"};
        IInputValidation inputValidation = new InputValidation();
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ValidateInputFile validate = new ValidateInputTenPinBowlFile(inputValidation, dataTransformation, dataValidation);
        validate.validateTurnsCountPerPlayer(contents);
    }

    @Test
    // When turns are 10 (two strikes on last frame)
    public void validateTurnsCountPerPlayer6() {
        String[] contents = {"Jeff\t10", "Jeff\t2", "Jeff\t6", "Jeff\t3", "Jeff\t7", "Jeff\t10", "Jeff\t10",
                "Jeff\t2", "Jeff\t6", "Jeff\t4", "Jeff\t5", "Jeff\t10", "Jeff\t10", "Jeff\t10", "Jeff\t10",
                "Jeff\t8"};
        IInputValidation inputValidation = new InputValidation();
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ValidateInputFile validate = new ValidateInputTenPinBowlFile(inputValidation, dataTransformation, dataValidation);
        validate.validateTurnsCountPerPlayer(contents);
    }

    @Test
    // When turns are 10 (two strikes on last frame, different throws)
    public void validateTurnsCountPerPlayer7() {
        String[] contents = {"Jeff\t10", "Jeff\t2", "Jeff\t6", "Jeff\t3", "Jeff\t7", "Jeff\t10", "Jeff\t10",
                "Jeff\t2", "Jeff\t6", "Jeff\t4", "Jeff\t5", "Jeff\t10", "Jeff\t10", "Jeff\t10", "Jeff\t8",
                "Jeff\t10"};
        IInputValidation inputValidation = new InputValidation();
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ValidateInputFile validate = new ValidateInputTenPinBowlFile(inputValidation, dataTransformation, dataValidation);
        validate.validateTurnsCountPerPlayer(contents);
    }

    @Test
    // When turns are 10 (two strikes on last frame, different throws)
    public void validateTurnsCountPerPlayer8() {
        String[] contents = {"Jeff\t10", "Jeff\t2", "Jeff\t6", "Jeff\t3", "Jeff\t7", "Jeff\t10", "Jeff\t10",
                "Jeff\t2", "Jeff\t6", "Jeff\t4", "Jeff\t5", "Jeff\t10", "Jeff\t10", "Jeff\t10", "Jeff\t10",
                "Jeff\t8"};
        IInputValidation inputValidation = new InputValidation();
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ValidateInputFile validate = new ValidateInputTenPinBowlFile(inputValidation, dataTransformation, dataValidation);
        validate.validateTurnsCountPerPlayer(contents);
    }

    @Test
    // When turns are 10 (all strikes for same player)
    public void validateTurnsCountPerPlayer9() {
        String[] contents = {"Jeff\t10", "Fernando\t10", "Jeff\t7", "Jeff\t3", "Fernando\t10", "Jeff\t9", "Jeff\t0",
                "Fernando\t10", "Jeff\t10", "Fernando\t10", "Jeff\t0", "Jeff\t8", "Fernando\t10", "Jeff\t8",
                "Jeff\t2", "Fernando\t10", "Jeff\tF", "Jeff\t6", "Fernando\t10", "Jeff\t10", "Fernando\t10",
                "Jeff\t10", "Fernando\t10", "Jeff\t10", "Jeff\t8", "Jeff\t1", "Fernando\t10", "Fernando\t10", "Fernando\t10"};
        IInputValidation inputValidation = new InputValidation();
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ValidateInputFile validate = new ValidateInputTenPinBowlFile(inputValidation, dataTransformation, dataValidation);
        validate.validateTurnsCountPerPlayer(contents);
    }

    @Test
    // When all results and their sums are correct
    public void validatePlayerResults1() {
        String[] contents = {"Jeff\t10", "John\t3", "John\t7", "Jeff\t7", "Jeff\t3", "John\t6", "John\t3", "Jeff\t9", "Jeff\t0",
                "John\t10", "Jeff\t10", "John\t8", "John\t1", "Jeff\t0", "Jeff\t8", "John\t10", "Jeff\t8", "Jeff\t2",
                "John\t10", "Jeff\tF", "Jeff\t6", "John\t9", "John\t0", "Jeff\t10", "John\t7", "John\t3", "Jeff\t10",
                "John\t4", "John\t4", "Jeff\t8", "Jeff\t2", "Jeff\t8", "John\t10", "John\t9", "John\t0"};
        IInputValidation inputValidation = new InputValidation();
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ValidateInputFile validate = new ValidateInputTenPinBowlFile(inputValidation, dataTransformation, dataValidation);
        validate.validateTurnsCountPerPlayer(contents);
        validate.validatePlayerResults(contents);
        Map<String, List<Integer>> playersResults = validate.getPlayersResultsByFrame();
        for (Map.Entry<String, List<Integer>> entry : playersResults.entrySet()) {
            for (Integer sum : entry.getValue()) {
                Assert.assertTrue(0 <= sum && sum <= 10);
            }
        }
    }

    @Test(expected = RuntimeException.class)
    // When a sum of result in a frame is greater than 10
    public void validatePlayerResults2() {
        String[] contents = {"Jeff\t10", "John\t4", "John\t7", "Jeff\t7", "Jeff\t3", "John\t6", "John\t3", "Jeff\t9", "Jeff\t0",
                "John\t10", "Jeff\t10", "John\t8", "John\t1", "Jeff\t0", "Jeff\t8", "John\t10", "Jeff\t8", "Jeff\t2",
                "John\t10", "Jeff\tF", "Jeff\t6", "John\t9", "John\t0", "Jeff\t10", "John\t7", "John\t3", "Jeff\t10",
                "John\t4", "John\t4", "Jeff\t8", "Jeff\t2", "Jeff\t8", "John\t10", "John\t9", "John\t0"};
        IInputValidation inputValidation = new InputValidation();
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ValidateInputFile validate = new ValidateInputTenPinBowlFile(inputValidation, dataTransformation, dataValidation);
        validate.validateTurnsCountPerPlayer(contents);
        validate.validatePlayerResults(contents);
        Map<String, List<Integer>> playersResults = validate.getPlayersResultsByFrame();
        for (Map.Entry<String, List<Integer>> entry : playersResults.entrySet()) {
            for (Integer sum : entry.getValue()) {
                Assert.assertTrue(0 <= sum && sum <= 10);
            }
        }
    }

    @Test(expected = RuntimeException.class)
    // When there's a negative result in a frame
    public void validatePlayerResults3() {
        String[] contents = {"Jeff\t-10", "John\t3", "John\t7", "Jeff\t7", "Jeff\t3", "John\t6", "John\t3", "Jeff\t9", "Jeff\t0",
                "John\t10", "Jeff\t10", "John\t8", "John\t1", "Jeff\t0", "Jeff\t8", "John\t10", "Jeff\t8", "Jeff\t2",
                "John\t10", "Jeff\tF", "Jeff\t6", "John\t9", "John\t0", "Jeff\t10", "John\t7", "John\t3", "Jeff\t10",
                "John\t4", "John\t4", "Jeff\t8", "Jeff\t3", "Jeff\t8", "John\t10", "John\t9", "John\t0"};
        IInputValidation inputValidation = new InputValidation();
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ValidateInputFile validate = new ValidateInputTenPinBowlFile(inputValidation, dataTransformation, dataValidation);
        validate.validateTurnsCountPerPlayer(contents);
        validate.validatePlayerResults(contents);
        Map<String, List<Integer>> playersResults = validate.getPlayersResultsByFrame();
        for (Map.Entry<String, List<Integer>> entry : playersResults.entrySet()) {
            for (Integer sum : entry.getValue()) {
                Assert.assertTrue(0 <= sum && sum <= 10);
            }
        }
    }
}