package racinggame;

import racinggame.config.CarRacingConfig;
import racinggame.controller.CarRacingController;

public class Application {
    public static void main(String[] args) {
        final CarRacingConfig config = new CarRacingConfig();
        final CarRacingController controller = config.carRacingController();

        controller.startGame();
    }
}
