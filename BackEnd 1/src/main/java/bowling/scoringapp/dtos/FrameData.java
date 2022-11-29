package bowling.scoringapp.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FrameData {
    @Getter
    @Setter
    @NonNull
    Integer frame;

    @Getter
    @Setter
    @NonNull
    String player;

    @Getter
    @Setter
    @NonNull
    Results results;
}
