package racingcar.service;

import racingcar.strategy.MoveStrategy;

public class RacingGameService {
    private final MoveStrategy moveStrategy;

    public RacingGameService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
}
