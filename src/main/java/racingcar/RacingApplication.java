package racingcar;

import racingcar.config.RacingConfig;
import racingcar.controller.RacingController;

public class RacingApplication {
    public static void main(String[] args) {
        RacingConfig config = new RacingConfig();
        RacingController controller = config.racingController();

        controller.startGame();
    }
}
