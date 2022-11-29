package bowling.utils.impl;

import bowling.utils.api.Constants;
import bowling.utils.api.IDataTransformation;
import bowling.utils.api.IDataValidation;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTransformation implements IDataTransformation {

    private final IDataValidation dataValidation;

    public DataTransformation(IDataValidation dataValidation) {
        this.dataValidation = dataValidation;
    }

    public Map<String, List<String>> transformResultsToMap(String[] lines) {
        Map<String, List<String>> playersResults = new HashMap<>();
        String player, result;
        int resultInt;
        for (String line : lines) {
            List<String> results;
            player = StringUtils.substringBefore(line, "\t");
            result = StringUtils.substringAfter(line, "\t");
            resultInt = dataValidation.getResultAsInteger(result);

            // Add every result to each player
            if (playersResults.containsKey(player))
                results = playersResults.get(player);
            else
                results = new ArrayList<>();

            results.add(String.valueOf(resultInt));
            // Add an empty result on strike
            if (resultInt == 10)
                results.add("");

            playersResults.put(player, results);
        }
        return playersResults;
    }

    private void reformatPlayersResults(Map<String, List<String>> playersResults) {
        int index, result1, resultsSize;
        for (Map.Entry<String, List<String>> entry : playersResults.entrySet()) {
            resultsSize = entry.getValue().size();
            if (resultsSize >= 22 && resultsSize <= 24) {
                List<String> resultList = entry.getValue();
                index = (Constants.NUMBER_OF_FRAMES - 1) * 2;
                // Get first result of last frame
                result1 = Integer.parseInt(resultList.get(index + 2));
                if (resultsSize == 22) {
                    if (result1 == 10) {
                        resultList.remove(index + 3);
                        entry.setValue(resultList);
                    }
                } else if (resultsSize == 23) {
                    if (result1 == 10)
                        resultList.remove(index + 3);
                    else
                        resultList.remove(index + 4);
                    entry.setValue(resultList);
                } else {
                    resultList.remove(index + 3);
                    result1 = Integer.parseInt(resultList.get(index + 3));
                    if (result1 == 10)
                        resultList.remove(index + 4);
                    entry.setValue(resultList);
                }
            }
        }
    }

    public Map<String, Integer> getTurnsByPlayer(Map<String, List<String>> playersResults) {
        Map<String, Integer> playersTurns = new HashMap<>();
        int counter, result1, result2, resultsSize, index;
        String player;
        // Remove empty results for strikes on two last throws, and when a strike happen on last frame
        reformatPlayersResults(playersResults);

        for (Map.Entry<String, List<String>> entry : playersResults.entrySet()) {
            player = entry.getKey();
            resultsSize = entry.getValue().size();
            // When results are lower than (NUMBER_OF_FRAMES * 2) or greater than ((NUMBER_OF_FRAMES * 2) + 2)
            if (resultsSize < (Constants.NUMBER_OF_FRAMES * 2) || resultsSize > ((Constants.NUMBER_OF_FRAMES * 2) + 2)) {
                playersTurns.put(player, 0);
                return playersTurns;
            }
            index = (Constants.NUMBER_OF_FRAMES - 1) * 2;

            // Get first result of last frame
            result1 = Integer.parseInt(entry.getValue().get(index));

            // When strike happens
            if (result1 == 10) {
                // Put 0 when there are no correct number of turns on a strike
                if (entry.getValue().size() != (Constants.NUMBER_OF_FRAMES * 2) + 2)
                    playersTurns.put(player, 0);
                else {
                    counter = Constants.NUMBER_OF_FRAMES + 2;
                    playersTurns.put(player, counter);
                }
            } else {
                result2 = Integer.parseInt(entry.getValue().get(index + 1));
                if (dataValidation.isPositiveInteger(result1) && dataValidation.isPositiveInteger(result2)) {
                    // When spare happens
                    if (result1 + result2 == 10) {
                        // Put 0 when there are no correct number of turns on a spare
                        if (entry.getValue().size() != (Constants.NUMBER_OF_FRAMES * 2) + 1)
                            playersTurns.put(player, 0);
                        else {
                            counter = Constants.NUMBER_OF_FRAMES + 1;
                            playersTurns.put(player, counter);
                        }
                    }
                    // When normal throw happens
                    else {
                        // Put 0 when there are no correct number of turns on a normal throw
                        if (entry.getValue().size() != Constants.NUMBER_OF_FRAMES * 2)
                            playersTurns.put(player, 0);
                        else {
                            counter = Constants.NUMBER_OF_FRAMES;
                            playersTurns.put(player, counter);
                        }
                    }
                }
                // When there's negative numbers on last results
                else
                    playersTurns.put(player, 0);
            }
        }
        return playersTurns;
    }
}
