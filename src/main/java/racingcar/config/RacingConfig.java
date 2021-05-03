package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameImpl;
import racingcar.service.RacingGameService;
import racingcar.strategy.CarGenerator;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RacingCarGenerator;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.*;

import java.util.Random;

public class RacingConfig {

    public RacingController racingController() {
        return new RacingController(racingGameService(), view());
    }

    private View view() {
        return new ViewImpl(inputView(), outputView());
    }

    private OutputView outputView() {
        return OutputViewImpl.getInstance();
    }

    private InputView inputView() {
        return InputViewImpl.getInstance();
    }

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
