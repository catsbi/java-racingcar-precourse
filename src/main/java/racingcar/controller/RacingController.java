package racingcar.controller;

import racingcar.domain.GameHistories;
import racingcar.service.RacingGameService;
import racingcar.view.View;

import java.util.List;

public class RacingController {
    private final RacingGameService racingGameService;
    private final View view;

    public RacingController(RacingGameService racingGameService, View view) {
        this.racingGameService = racingGameService;
        this.view = view;
    }

    public void startGame() {
        List<String> carNames = view.questionCarNames();
        int round = view.questionRound();

        GameHistories gameResult = racingGameService.playGame(carNames, round);

        view.renderRacingProcess(gameResult);
        view.renderWinners(gameResult);

    }
}
