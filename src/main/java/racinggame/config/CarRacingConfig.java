package racinggame.config;

import racingcar.validation.DistanceValidator;
import racingcar.validation.NameValidator;
import racingcar.validation.RoundValidator;
import racingcar.validation.Validators;
import racinggame.application.CarRacingService;
import racinggame.controller.CarRacingController;
import racinggame.domain.Distance;
import racinggame.domain.Name;
import racinggame.domain.Round;
import racinggame.strategy.MoveStrategy;
import racinggame.strategy.RandomMoveStrategy;
import racinggame.view.CarRacingInputView;
import racinggame.view.CarRacingInputViewImpl;
import racinggame.view.CarRacingOutputView;
import racinggame.view.CarRacingOutputViewImpl;
import racinggame.view.CarRacingView;
import racinggame.view.CarRacingViewImpl;

/**
 * 자동차 경주 게임 클래스 의존 관계 설정
 */
public class CarRacingConfig {

    public CarRacingConfig() {
        Validators.addValidator(Name.class, new NameValidator());
        Validators.addValidator(Distance.class, new DistanceValidator());
        Validators.addValidator(Round.class, new RoundValidator());
    }

    public CarRacingController carRacingController() {
        return new CarRacingController(carRacingService(), carRacingView());
    }

    private CarRacingView carRacingView() {
        return new CarRacingViewImpl(carRacingInputView(), carRacingOutputView());
    }

    private CarRacingOutputView carRacingOutputView() {
        return new CarRacingOutputViewImpl();
    }

    private CarRacingInputView carRacingInputView() {
        return new CarRacingInputViewImpl();
    }

    private CarRacingService carRacingService() {
        return new CarRacingService(moveStrategy());
    }

    private MoveStrategy moveStrategy() {
        return new RandomMoveStrategy();
    }
}
