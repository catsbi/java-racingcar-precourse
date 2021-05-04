package racingcar.fakeobject;

import racingcar.strategy.MoveStrategy;

public class TestTargetMoveStrategy implements MoveStrategy {
    public static final MoveStrategy testTargetMoveStrategy = new TestTargetMoveStrategy();

    public static final int ANCHOR_POINT = 3;

    private int targetCount;

    public void setTargetCount(int targetCount) {
        this.targetCount = targetCount;
    }

    @Override
    public boolean isMovable() {
        return targetCount > ANCHOR_POINT;
    }
}
