package racingcar.config;

import racingcar.fakeobject.TestMoveStrategy;
import racingcar.strategy.MoveStrategy;

public class TestRacingConfig extends RacingConfig{

    @Override
    public MoveStrategy moveStrategy() {
        return TestMoveStrategy.alwaysTrueMoveStrategy;
    }
}
