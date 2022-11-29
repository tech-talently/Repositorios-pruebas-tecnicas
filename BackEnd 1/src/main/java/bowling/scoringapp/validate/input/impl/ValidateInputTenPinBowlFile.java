package bowling.scoringapp.validate.input.impl;

import bowling.scoringapp.validate.input.api.ValidateInputFile;
import bowling.utils.api.ErrorMessages;
import bowling.utils.api.IDataTransformation;
import bowling.utils.api.IDataValidation;
import bowling.utils.api.IInputValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ValidateInputTenPinBowlFile extends ValidateInputFile {

    private final IInputValidation inputValidation;
    private final IDataTransformation dataTransformation;
    private final IDataValidation dataValidation;

    public ValidateInputTenPinBowlFile(IInputValidation inputValidation, IDataTransformation dataTransformation, IDataValidation dataValidation) {
        this.inputValidation = inputValidation;
        this.dataTransformation = dataTransformation;
        this.dataValidation = dataValidation;
    }

    @Override
    public void validateEmptyLines(String[] lines) {
        for (String line : lines) {
            if (inputValidation.isEmptyLine(line))
                throw new RuntimeException(ErrorMessages.FILE_EMPTY_LINE);
        }
    }

    @Override
    public void validateTurnsCountPerPlayer(String[] lines) {
        String player;
        int result;
        int counter;

        // Get results by player
        playersResults = dataTransformation.transformResultsToMap(lines);

        // Count turns by player
        playersTurns = dataTransformation.getTurnsByPlayer(playersResults);

        // Validate an exact number of turns
        for (Map.Entry<String, Integer> entry : playersTurns.entrySet()) {
            player = entry.getKey();
            result = entry.getValue();
            // When there's a strike on last frame diminish two turns
            if (result == 12) {
                counter = playersTurns.get(player);
                counter -= 2;
                playersTurns.put(player, counter);
            }
            // When there's a spare on last frame diminish one turn
            else if (result == 11) {
                counter = playersTurns.get(player) == null ? 0 : playersTurns.get(player);
                counter -= 1;
                playersTurns.put(player, counter);
            }

            // Throw exception when the number of turns is not correct
            if (entry.getValue().equals(0)) {
                throw new RuntimeException(ErrorMessages.FILE_INVALID_THROWS_COUNT);
            }
        }
    }

    public void validatePlayerResults(String[] lines) {
        // Get results by player
        playersResults = dataTransformation.transformResultsToMap(lines);
        // Get number of turns by player
        playersTurns = dataTransformation.getTurnsByPlayer(playersResults);
        // Get results by frame and by player
        playersResultsByFrame = getResultsByFrameByPlayer();

        // Validate results by frame are >=0 or <=10
        for (Map.Entry<String, List<Integer>> entry : playersResultsByFrame.entrySet()) {
            for (Integer sum : entry.getValue()) {
                if (sum < 0 || sum > 10)
                    throw new RuntimeException(ErrorMessages.FILE_INVALID_SUM_PLAYER_RESULTS);
            }
        }
    }

    private Map<String, List<Integer>> getResultsByFrameByPlayer() {
        int result1, result2;
        for (Map.Entry<String, List<String>> entry : playersResults.entrySet()) {
            int counter = 0;
            String player = entry.getKey();
            List<Integer> playerResultsByFrame = new ArrayList<>();
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (!"".equals(entry.getValue().get(i))) {
                    result1 = Integer.parseInt(entry.getValue().get(i));
                    if (!dataValidation.isPositiveInteger(result1)) {
                        throw new RuntimeException(ErrorMessages.FILE_INVALID_INDIVIDUAL_PLAYER_RESULT);
                    }
                    if (counter < 9 && result1 == 10) {
                        playerResultsByFrame.add(result1);
                        counter++;
                    } else {
                        if (counter < 9) {
                            result2 = Integer.parseInt(entry.getValue().get(i + 1));
                            if (!dataValidation.isPositiveInteger(result2)) {
                                throw new RuntimeException(ErrorMessages.FILE_INVALID_INDIVIDUAL_PLAYER_RESULT);
                            }
                            playerResultsByFrame.add(result1 + result2);
                            counter++;
                            // Add one to skip next item on results list
                            i = i + 1;
                        } else if (counter == 9) {
                            // If no strike or spare happened on last turn
                            if (playersTurns.get(player) == 10) {
                                result2 = Integer.parseInt(entry.getValue().get(i + 1));
                                if (!dataValidation.isPositiveInteger(result2)) {
                                    throw new RuntimeException(ErrorMessages.FILE_INVALID_INDIVIDUAL_PLAYER_RESULT);
                                }
                                playerResultsByFrame.add(result1 + result2);
                                counter++;
                                // Add one to skip next item on results list
                                i = i + 1;
                            }
                            // When spare happens on last frame
                            else if (playersTurns.get(player) == 11) {
                                result2 = Integer.parseInt(entry.getValue().get(i + 1));
                                if (!dataValidation.isPositiveInteger(result2)) {
                                    throw new RuntimeException(ErrorMessages.FILE_INVALID_INDIVIDUAL_PLAYER_RESULT);
                                }
                                playerResultsByFrame.add(result1 + result2);
                                counter++;
                                // Store one additional turn
                                result1 = Integer.parseInt(entry.getValue().get(i + 2));
                                if (!dataValidation.isPositiveInteger(result1)) {
                                    throw new RuntimeException(ErrorMessages.FILE_INVALID_INDIVIDUAL_PLAYER_RESULT);
                                }
                                playerResultsByFrame.add(result1);
                                counter++;
                                // Add two to skip next items on results list
                                i = i + 2;
                            }
                            // When strike happens on last frame
                            else if (playersTurns.get(player) == 12) {
                                playerResultsByFrame.add(result1);
                                counter++;
                                // Store two additional turns
                                result1 = Integer.parseInt(entry.getValue().get(i + 2));
                                if (!dataValidation.isPositiveInteger(result1)) {
                                    throw new RuntimeException(ErrorMessages.FILE_INVALID_INDIVIDUAL_PLAYER_RESULT);
                                }
                                playerResultsByFrame.add(result1);
                                counter++;
                                result1 = Integer.parseInt(entry.getValue().get(i + 3));
                                if (!dataValidation.isPositiveInteger(result1)) {
                                    throw new RuntimeException(ErrorMessages.FILE_INVALID_INDIVIDUAL_PLAYER_RESULT);
                                }
                                playerResultsByFrame.add(result1);
                                counter++;
                                // Add three to skip next items on results list
                                i = i + 4;
                            }
                        }
                    }
                }
            }
            playersResultsByFrame.put(player, playerResultsByFrame);
        }
        return playersResultsByFrame;
    }
}
