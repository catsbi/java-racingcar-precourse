package racingcar.view;

import racingcar.dto.GameResultResponse;

public interface OutputView {
    void renderRacingProcess(GameResultResponse response);

    void renderWinners(GameResultResponse response);
}
