package bowling.scoringapp.dtos;

import lombok.*;

import java.util.List;

@RequiredArgsConstructor
@ToString
public class Results {
    @Getter
    @Setter
    @NonNull
    List<String> pinFalls;

    @Getter
    @Setter
    @NonNull
    Character mark;

    @Getter
    @Setter
    Integer score;
}
