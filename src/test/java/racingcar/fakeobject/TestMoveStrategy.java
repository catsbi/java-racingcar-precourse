package racingcar.fakeobject;

import racingcar.strategy.MoveStrategy;

public class TestMoveStrategy implements MoveStrategy {
    private int testPoint;

    public TestMoveStrategy(int number) {
        this.testPoint = number;
    }

    @Override
    public boolean isMovable() {
        return testPoint > 3;
    }
}
