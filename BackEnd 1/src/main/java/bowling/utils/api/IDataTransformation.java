package bowling.utils.api;

import java.util.List;
import java.util.Map;

public interface IDataTransformation {
    Map<String, List<String>> transformResultsToMap(String[] lines);

    Map<String, Integer> getTurnsByPlayer(Map<String, List<String>> playersResults);
}
