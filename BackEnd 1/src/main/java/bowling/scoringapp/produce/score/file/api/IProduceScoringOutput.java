package bowling.scoringapp.produce.score.file.api;

import bowling.scoringapp.dtos.FrameData;

public interface IProduceScoringOutput {
    String[] produceScoringOutput(FrameData[][] allFrames);
}
