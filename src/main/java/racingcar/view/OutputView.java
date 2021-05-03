package racingcar.view;

import racingcar.domain.GameHistories;

public interface OutputView {
    void renderRacingProcess(GameHistories result);

    void renderWinners(GameHistories result);
}
