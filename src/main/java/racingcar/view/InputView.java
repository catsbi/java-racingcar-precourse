package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Round;

import java.util.List;

public interface InputView {

    Round questionRound();

    List<Car> questionCarNames();

}
