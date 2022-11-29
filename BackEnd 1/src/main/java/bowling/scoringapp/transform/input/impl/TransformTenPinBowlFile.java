package bowling.scoringapp.transform.input.impl;

import bowling.scoringapp.dtos.FrameData;
import bowling.scoringapp.dtos.Results;
import bowling.scoringapp.transform.input.api.ITransformInput;
import bowling.utils.api.Constants;
import bowling.utils.api.IDataTransformation;
import bowling.utils.api.IDataValidation;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class TransformTenPinBowlFile implements ITransformInput {
    private final IDataTransformation dataTransformation;
    private final IDataValidation dataValidation;

    public TransformTenPinBowlFile(IDataTransformation dataTransformation, IDataValidation dataValidation) {
        this.dataTransformation = dataTransformation;
        this.dataValidation = dataValidation;
    }

    @Override
    public FrameData[][] transformInputByFrameByPlayer(String[] lines) {
        Map<String, List<String>> playersResults = dataTransformation.transformResultsToMap(lines);
        Map<String, Integer> playersTurns = dataTransformation.getTurnsByPlayer(playersResults);
        Set<String> playersNames = playersResults.keySet();
        FrameData[][] allFrames = new FrameData[playersNames.size()][Constants.NUMBER_OF_FRAMES];
        int counter = 0;
        String player;
        for (Iterator<String> it = playersNames.iterator(); it.hasNext(); counter++) {
            player = it.next();
            FrameData[] frames = transformInputByFrameByPlayer(lines, player, playersTurns.get(player));
            allFrames[counter] = frames;
        }
        return allFrames;
    }

    private FrameData[] transformInputByFrameByPlayer(String[] lines, String player, int playerTurns) {
        FrameData[] frames = new FrameData[Constants.NUMBER_OF_FRAMES];
        FrameData frameData;
        String playerLine, result1, result2, result3;
        int counter = 0, result1Int, result2Int;
        char mark;
        for (int i = 0; i < lines.length; i++) {
            playerLine = StringUtils.substringBefore(lines[i], "\t");
            // Identify result as a number, F or a different text (in that case will be -100000)
            result1 = dataValidation.getResultAsString(StringUtils.substringAfter(lines[i], "\t"));
            if (playerLine.equals(player)) {
                // Add results for all frames except last one
                if (counter < (Constants.NUMBER_OF_FRAMES - 1) && result1.equals("10")) {
                    mark = 'X';
                    frameData = fillDTO(mark, playerLine, counter + 1, result1, "");
                    // Add frame to array
                    frames[counter] = frameData;
                    counter++;
                }
                // Add results for last frame or when result is different from 10
                else {
                    if (counter < (Constants.NUMBER_OF_FRAMES - 1)) {
                        result2 = dataValidation.getResultAsString(StringUtils.substringAfter(lines[i + 1], "\t"));
                        result1Int = result1.equals("F") ? 0 : Integer.parseInt(result1);
                        result2Int = result2.equals("F") ? 0 : Integer.parseInt(result2);
                        // When a spare happens
                        if (result1Int + result2Int == 10)
                            mark = '/';
                            // When a normal turn happens
                        else
                            mark = '#';

                        frameData = fillDTO(mark, playerLine, counter + 1, result1, result2);
                        // Add frame to array
                        frames[counter] = frameData;
                        counter++;
                        // Add one to skip next line
                        i = i + 1;
                    } else if (counter == (Constants.NUMBER_OF_FRAMES - 1)) {
                        // If no strike or spare happened on last turn
                        if (playerTurns == Constants.NUMBER_OF_FRAMES) {
                            result2 = dataValidation.getResultAsString(StringUtils.substringAfter(lines[i + 1], "\t"));
                            mark = '#';
                            frameData = fillDTO(mark, playerLine, counter + 1, result1, result2);
                            // Add frame to array
                            frames[counter] = frameData;
                            counter++;
                            // Add one to skip next line
                            i = i + 1;
                        }
                        // When spare happens on last frame
                        else if (playerTurns == (Constants.NUMBER_OF_FRAMES + 1)) {
                            result2 = dataValidation.getResultAsString(StringUtils.substringAfter(lines[i + 1], "\t"));
                            // Store one additional turn
                            result3 = dataValidation.getResultAsString(StringUtils.substringAfter(lines[i + 2], "\t"));
                            mark = '/';
                            frameData = fillDTO(mark, playerLine, counter + 1, result1, result2, result3);
                            // Add frame to array
                            frames[counter] = frameData;
                            counter++;
                            // Add two to skip next lines
                            i = i + 2;
                        }
                        // When strike happens on last frame
                        else if (playerTurns == (Constants.NUMBER_OF_FRAMES + 2)) {
                            result2 = dataValidation.getResultAsString(StringUtils.substringAfter(lines[i + 1], "\t"));
                            // Store two additional turns
                            result3 = dataValidation.getResultAsString(StringUtils.substringAfter(lines[i + 2], "\t"));
                            mark = 'X';
                            frameData = fillDTO(mark, playerLine, counter + 1, result1, result2, result3);
                            // Add frame to array
                            frames[counter] = frameData;
                            counter++;
                            // Add three to skip next lines
                            i = i + 2;
                        }
                    }
                }
            }
        }
        return frames;
    }

    private FrameData fillDTO(Character mark, String player, Integer counter, String... values) {
        FrameData frameData = new FrameData();
        Results results = new Results(new ArrayList<>(), mark);
        List<String> pinFalls = new ArrayList<>();
        Collections.addAll(pinFalls, values);
        results.setPinFalls(pinFalls);
        results.setMark(mark);
        frameData.setFrame(counter);
        frameData.setPlayer(player);
        frameData.setResults(results);
        return frameData;
    }

}
