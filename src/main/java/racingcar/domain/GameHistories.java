package racingcar.domain;

import racingcar.dto.Winners;
import racingcar.exceptions.InvalidParameterException;

import java.util.*;

public class GameHistories {
    public static final int VALID_MIN_SEQUENCE = 0;

    private final List<GameHistory> histories;

    public GameHistories() {
        histories = new ArrayList<>();
    }

    public void appendHistory(GameHistory history) {
        histories.add(history);
    }

    public List<GameHistory> values() {
        return new ArrayList<>(histories);
    }

    public GameHistory lastHistory() {
        return histories.get(size() - 1);
    }

    public GameHistory get(int index) {
        validateIndex(index);
        return histories.get(index);
    }

    private void validateIndex(int index) {
        if (index < VALID_MIN_SEQUENCE || index >= size()) {
            throw new InvalidParameterException();
        }
    }

    public Winners getWinners() {
        GameHistory gameHistory = lastHistory();
        return gameHistory.getWinners();
    }

    public int size() {
        return histories.size();
    }
}
