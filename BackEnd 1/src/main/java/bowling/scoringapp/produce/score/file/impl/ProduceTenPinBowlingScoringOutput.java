package bowling.scoringapp.produce.score.file.impl;

import bowling.scoringapp.dtos.FrameData;
import bowling.scoringapp.produce.score.file.api.IProduceScoringOutput;
import bowling.utils.api.Constants;

public class ProduceTenPinBowlingScoringOutput implements IProduceScoringOutput {

    @Override
    public String[] produceScoringOutput(FrameData[][] allFrames) {
        return createScoringOutput(allFrames);
    }

    private String[] createScoringOutput(FrameData[][] allFrames) {
        String[] lines = new String[(allFrames.length * 3) + 1];
        StringBuilder builderLine1 = new StringBuilder();
        StringBuilder builderLine2 = new StringBuilder();
        builderLine1.append("Frame");
        for (int i = 1; i <= 10; i++) {
            builderLine1.append(" ");
            builderLine1.append(Constants.FILE_TAB_DELIMITER);
            builderLine1.append(Constants.FILE_TAB_DELIMITER);
            builderLine1.append(i);
        }
        lines[0] = builderLine1.toString();
        builderLine1.setLength(0);
        String result1, result2, result3;
        Character mark;
        int score, k = 1;
        for (FrameData[] allFrame : allFrames) {
            builderLine1.append(allFrame[0].getPlayer());
            lines[k] = builderLine1.toString();
            k++;
            builderLine1.setLength(0);
            builderLine1.append("Pinfalls");
            builderLine2.append("Score ");
            for (int j = 0; j < allFrame.length; j++) {
                builderLine2.append(Constants.FILE_TAB_DELIMITER);
                score = allFrame[j].getResults().getScore();
                builderLine2.append(Constants.FILE_TAB_DELIMITER);
                builderLine2.append(score);
                mark = allFrame[j].getResults().getMark();
                if (j < allFrame.length - 1) {
                    result1 = allFrame[j].getResults().getPinFalls().get(0);
                    result2 = allFrame[j].getResults().getPinFalls().get(1);
                    // When normal result
                    if (mark.equals('#')) {
                        builderLine1.append(Constants.FILE_TAB_DELIMITER);
                        builderLine1.append(result1);
                        builderLine1.append(Constants.FILE_TAB_DELIMITER);
                        builderLine1.append(result2);
                    }
                    // When spare happens
                    else if (mark.equals('/')) {
                        builderLine1.append(Constants.FILE_TAB_DELIMITER);
                        builderLine1.append(result1);
                        builderLine1.append(Constants.FILE_TAB_DELIMITER);
                        builderLine1.append(mark);
                    }
                    // When strike happens
                    else if (mark.equals('X')) {
                        builderLine1.append(Constants.FILE_TAB_DELIMITER);
                        builderLine1.append(" ");
                        builderLine1.append(Constants.FILE_TAB_DELIMITER);
                        builderLine1.append(mark);
                    }
                } else {
                    result1 = allFrame[j].getResults().getPinFalls().get(0);
                    result2 = allFrame[j].getResults().getPinFalls().get(1);
                    // When normal result
                    if (mark.equals('#')) {
                        builderLine1.append(Constants.FILE_TAB_DELIMITER);
                        builderLine1.append(result1);
                        builderLine1.append(Constants.FILE_TAB_DELIMITER);
                        builderLine1.append(result2);
                    }
                    // When spare happens
                    else if (mark.equals('/')) {
                        result3 = allFrame[j].getResults().getPinFalls().get(2);
                        builderLine1.append(Constants.FILE_TAB_DELIMITER);
                        builderLine1.append(result1);
                        builderLine1.append(Constants.FILE_TAB_DELIMITER);
                        builderLine1.append(mark);
                        builderLine1.append(Constants.FILE_TAB_DELIMITER);
                        builderLine1.append(result3);
                    }
                    // When strike happens
                    else if (mark.equals('X')) {
                        result3 = allFrame[j].getResults().getPinFalls().get(2);
                        builderLine1.append(Constants.FILE_TAB_DELIMITER);
                        builderLine1.append(mark);
                        builderLine1.append(Constants.FILE_TAB_DELIMITER);
                        builderLine1.append(result2);
                        builderLine1.append(Constants.FILE_TAB_DELIMITER);
                        builderLine1.append(result3);
                    }
                }
            }
            lines[k] = builderLine1.toString();
            ++k;
            builderLine1.setLength(0);
            lines[k] = builderLine2.toString();
            ++k;
            builderLine2.setLength(0);
        }
        return lines;
    }
}
