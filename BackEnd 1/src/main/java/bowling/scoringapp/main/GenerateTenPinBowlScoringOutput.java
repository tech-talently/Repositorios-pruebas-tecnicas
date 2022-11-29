package bowling.scoringapp.main;

import bowling.scoringapp.dtos.FrameData;
import bowling.scoringapp.generate.score.api.IGenerateScoring;
import bowling.scoringapp.generate.score.impl.GenerateTenPinBowlScoring;
import bowling.scoringapp.produce.score.file.api.IProduceScoringOutput;
import bowling.scoringapp.produce.score.file.impl.ProduceTenPinBowlingScoringOutput;
import bowling.scoringapp.transform.input.api.ITransformInput;
import bowling.scoringapp.transform.input.impl.TransformTenPinBowlFile;
import bowling.scoringapp.validate.input.api.ValidateInputFile;
import bowling.scoringapp.validate.input.impl.ValidateInputTenPinBowlFile;
import bowling.utils.api.Constants;
import bowling.utils.api.IDataTransformation;
import bowling.utils.api.IDataValidation;
import bowling.utils.api.IInputValidation;
import bowling.utils.impl.DataTransformation;
import bowling.utils.impl.DataValidation;
import bowling.utils.impl.InputValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GenerateTenPinBowlScoringOutput {
    public static void main(String[] args) {
        File file = new File(args[0]);

        GenerateTenPinBowlScoringOutput generateScoringOutput = new GenerateTenPinBowlScoringOutput();
        // Read file and store data into lines array
        String fileContent = generateScoringOutput.readFromInputStream(file);
        String[] lines = fileContent.split(Constants.FILE_DELIMITER);
        // Validate contents of file
        generateScoringOutput.validateInputFile(lines);
        // Transform input into objects and generate scores
        FrameData[][] allFrames = generateScoringOutput.produceScoring(lines);
        // Generate scoring output
        generateScoringOutput.createScoringOutput(allFrames);
    }

    public String readFromInputStream(File file) {
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

    public void validateInputFile(String[] lines) {
        IInputValidation inputValidation = new InputValidation();
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ValidateInputFile validate = new ValidateInputTenPinBowlFile(inputValidation, dataTransformation, dataValidation);
        // Validate if there's empty lines in file
        validate.validateEmptyLines(lines);
        // Validate throws count by player
        validate.validateTurnsCountPerPlayer(lines);
        // Validate results by player
        validate.validatePlayerResults(lines);
    }

    public FrameData[][] produceScoring(String[] lines) {
        IDataValidation dataValidation = new DataValidation();
        IDataTransformation dataTransformation = new DataTransformation(dataValidation);
        ITransformInput transformInput = new TransformTenPinBowlFile(dataTransformation, dataValidation);
        FrameData[][] allFrames = transformInput.transformInputByFrameByPlayer(lines);
        IGenerateScoring produceScoring = new GenerateTenPinBowlScoring(dataValidation);
        return produceScoring.calculateScores(allFrames);
    }

    public String[] createScoringOutput(FrameData[][] allFrames) {
        IProduceScoringOutput produceScoringOutput = new ProduceTenPinBowlingScoringOutput();
        String[] outputLines = produceScoringOutput.produceScoringOutput(allFrames);
        for (String line : outputLines) {
            System.out.println(line);
        }
        return outputLines;
    }
}
