package racinggame.domain;

/**
 * 게임 진행 횟수 정보
 */
public class Round {
    private int progress;
    private final int end;

    public Round(int round) {
        this.progress = 0;
        this.end = round;
    }

    public boolean hasNext() {
        return progress < end;
    }

    public int next() {
        return ++progress;
    }
}
