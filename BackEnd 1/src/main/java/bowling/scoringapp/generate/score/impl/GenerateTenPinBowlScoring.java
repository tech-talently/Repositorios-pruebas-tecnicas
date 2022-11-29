package bowling.scoringapp.generate.score.impl;

import bowling.scoringapp.dtos.FrameData;
import bowling.scoringapp.generate.score.api.IGenerateScoring;
import bowling.utils.api.IDataValidation;

import java.util.List;

public class GenerateTenPinBowlScoring implements IGenerateScoring {

    private final IDataValidation dataValidation;

    public GenerateTenPinBowlScoring(IDataValidation dataValidation) {
        this.dataValidation = dataValidation;
    }

    @Override
    public FrameData[][] calculateScores(FrameData[][] allFrames) {
        String nextResult1, nextResult2;
        int nextResultInt1;
        for (FrameData[] allFrame : allFrames) {
            int score = 0;
            for (int j = 0; j < allFrame.length; j++) {
                Character mark = allFrame[j].getResults().getMark();
                // When normal turn
                if (mark.equals('#')) {
                    score += calculateTotalResult(allFrame[j].getResults().getPinFalls());
                    allFrame[j].getResults().setScore(score);
                }
                // When spare happens
                else if (mark.equals('/')) {
                    // Get result from next throw on all frames except last one
                    if (j < allFrame.length - 1) {
                        String nextResult = allFrame[j + 1].getResults().getPinFalls().get(0);
                        score += 10 + dataValidation.getResultAsInteger(nextResult);
                        allFrame[j].getResults().setScore(score);
                    }
                    // Get result from last throw on last frame
                    else {
                        String lastResult = allFrame[j].getResults().getPinFalls().get(2);
                        score += 10 + dataValidation.getResultAsInteger(lastResult);
                        allFrame[j].getResults().setScore(score);
                    }
                } else if (mark.equals('X')) {
                    // Get results from next two throws on all frames except last two
                    if ((j + 1) < allFrame.length - 1) {
                        nextResult1 = allFrame[j + 1].getResults().getPinFalls().get(0);
                        // When strike happens on next throw
                        if (dataValidation.getResultAsInteger(nextResult1) == 10) {
                            nextResult2 = allFrame[j + 2].getResults().getPinFalls().get(0);
                        }
                        // When no strike happens on next throw
                        else {
                            nextResult2 = allFrame[j + 1].getResults().getPinFalls().get(1);
                        }
                        score += 10 + dataValidation.getResultAsInteger(nextResult1)
                                + dataValidation.getResultAsInteger(nextResult2);
                        allFrame[j].getResults().setScore(score);
                    }
                    // Get results from next two throws on penultimate frame
                    else if ((j + 1) == allFrame.length - 1) {
                        int bonus;
                        nextResult1 = allFrame[j + 1].getResults().getPinFalls().get(0);
                        nextResult2 = allFrame[j + 1].getResults().getPinFalls().get(1);
                        nextResultInt1 = dataValidation.getResultAsInteger(nextResult1);
                        // When there was strike on last frame
                        bonus = nextResultInt1 + dataValidation.getResultAsInteger(nextResult2);
                        score += 10 + bonus;
                        allFrame[j].getResults().setScore(score);
                    }
                    // Get results from next two throws on last frame
                    else {
                        nextResult1 = allFrame[j].getResults().getPinFalls().get(1);
                        nextResult2 = allFrame[j].getResults().getPinFalls().get(2);
                        score += 10 + dataValidation.getResultAsInteger(nextResult1)
                                + dataValidation.getResultAsInteger(nextResult2);
                        allFrame[j].getResults().setScore(score);
                    }
                }
            }
        }
        return allFrames;
    }

    private int calculateTotalResult(List<String> results) {
        int sum = 0;
        for (String result : results)
            sum += dataValidation.getResultAsInteger(result);
        return sum;
    }

}
