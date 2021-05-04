package racingcar.fakeobject;

import racingcar.strategy.MoveStrategy;

public class TestMoveStrategy implements MoveStrategy {
    public static final MoveStrategy alwaysTrueMoveStrategy = new TestMoveStrategy(true);
    public static final MoveStrategy alwaysFalseMoveStrategy = new TestMoveStrategy(false);

    private final boolean movable;

    public TestMoveStrategy(boolean movable) {
        this.movable = movable;
    }

    @Override
    public boolean isMovable() {
        return movable;
    }
}
