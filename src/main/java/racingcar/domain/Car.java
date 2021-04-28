package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public interface Car {

    CarName getName();

    void move(MoveStrategy strategy);

    Point getCurrentPoint();
}
