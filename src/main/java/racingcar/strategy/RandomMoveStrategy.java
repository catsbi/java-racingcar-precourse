package racingcar.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{
    public static final int RANDOM_MAX_NUMBER = 10;
    public static final int ANCHOR_POINT = 3;

    private final Random random;

    public RandomMoveStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean execute() {
        return random.nextInt(RANDOM_MAX_NUMBER) > ANCHOR_POINT;
    }
}
