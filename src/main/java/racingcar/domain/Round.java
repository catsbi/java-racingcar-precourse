package racingcar.domain;

import racingcar.exceptions.InvalidRoundException;
import racingcar.exceptions.NotExistsNextRoundException;

public class Round {
    public static final int INIT_ROUND = 0;

    private final int totalRound;
    private int currentRound;

    public Round(int totalRound) {
        validateTotalRound(totalRound);
        this.totalRound = totalRound;
        this.currentRound = INIT_ROUND;
    }

    private void validateTotalRound(int totalRound) {
        if (totalRound <= 0) {
            throw new InvalidRoundException();
        }
    }

    public int getTotalRound() {
        return totalRound;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public int nextRound() {
        if (hasNextRound()) {
            return ++currentRound;
        }
        throw new NotExistsNextRoundException();
    }

    public boolean hasNextRound() {
        return totalRound > currentRound;
    }
}
