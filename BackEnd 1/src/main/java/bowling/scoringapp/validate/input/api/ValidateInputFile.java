package bowling.scoringapp.validate.input.api;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ValidateInputFile {
    @Getter
    protected Map<String, List<String>> playersResults = new HashMap<>();
    @Getter
    protected Map<String, Integer> playersTurns = new HashMap<>();
    @Getter
    protected Map<String, List<Integer>> playersResultsByFrame = new HashMap<>();

    public void validateTurnsCountPerPlayer(String[] lines) {
    }

    public void validatePlayerResults(String[] lines) {
    }

    public void validateEmptyLines(String[] lines) {
    }
}
