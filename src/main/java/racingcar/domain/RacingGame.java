package racingcar.domain;

import racingcar.dto.GameResultResponse;
import racingcar.strategy.MoveStrategy;

import java.util.List;

public interface RacingGame {
    void appendCar(Car car);

    void appendCar(List<Car> cars);

    void appendCar(Cars cars);

    void play(MoveStrategy strategy);

    GameResultResponse getResult();
}
