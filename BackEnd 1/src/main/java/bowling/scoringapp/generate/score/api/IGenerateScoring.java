package bowling.scoringapp.generate.score.api;

import bowling.scoringapp.dtos.FrameData;

public interface IGenerateScoring {
    FrameData[][] calculateScores(FrameData[][] allResults);
}
