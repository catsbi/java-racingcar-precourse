package racingcar.config;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameImpl;
import racingcar.service.RacingGameService;
import racingcar.strategy.CarGenerator;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RacingCarGenerator;
import racingcar.strategy.RandomMoveStrategy;

import java.util.Random;

public class RacingConfig {

    public RacingGameService racingGameService() {
        return new RacingGameService(racingGame());
    }

    public RacingGame racingGame() {
        return new RacingGameImpl(carGenerator(), moveStrategy());
    }

    public MoveStrategy moveStrategy() {
        return new RandomMoveStrategy(new Random());
    }

    public CarGenerator carGenerator() {
        return new RacingCarGenerator();
    }
}
