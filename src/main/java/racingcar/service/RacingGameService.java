package racingcar.service;

import racingcar.domain.GameHistories;
import racingcar.domain.RacingGame;

import java.util.List;

public class RacingGameService {
    private final RacingGame racingGame;

    public RacingGameService(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public GameHistories playGame(List<String> names, int roundCount) {
        racingGame.appendCar(names);
        racingGame.play(roundCount);

        return racingGame.getResult();
    }
}
