package racingcar.domain;

import racingcar.dto.Winners;
import racingcar.exceptions.InvalidParameterException;

import java.util.*;

public class GameHistories {
    public static final int VALID_MIN_SEQUENCE= 1;

    private final Map<Integer, GameHistory> histories;
    private static Integer sequence = 0;

    public GameHistories() {
        histories = new HashMap<>();
    }

    public void appendHistory(GameHistory history) {
        histories.put(++sequence, history);
    }

    public Set<Integer> keys() {
        return new HashSet<>(histories.keySet());
    }

    public Collection<GameHistory> values() {
        return new ArrayList<>(histories.values());
    }

    public GameHistory lastHistory() {
        return histories.get(sequence);
    }

    public GameHistory get(int index) {
        validateIndex(index);
        return histories.get(index);
    }

    private void validateIndex(int index) {
        if (index < VALID_MIN_SEQUENCE || index > sequence) {
            throw new InvalidParameterException();
        }
    }

    public Winners getWinners() {
        GameHistory gameHistory = lastHistory();
        return gameHistory.getWinners();
    }
}
