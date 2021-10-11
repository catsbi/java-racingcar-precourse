package racinggame.application;

import racinggame.domain.Cars;
import racinggame.dto.CarData;
import racinggame.dto.CarRacingProgress;
import racinggame.dto.CarRacingProgressList;
import racinggame.strategy.MoveStrategy;

/**
 * 자동차 경주에 대한 서비스를 제공한다.
 */
public class CarRacingService {
    private final MoveStrategy moveStrategy;

    public CarRacingService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public CarRacingProgressList carRacing(String names, int round) {
        CarRacingProgressList progressList = new CarRacingProgressList();
        final Cars cars = Cars.from(names);

        for (int i = 0; i < round; i++) {
            cars.notifyAll(car -> car.move(moveStrategy));
            final CarRacingProgress progress = CarRacingProgress.from(cars.map(CarData::from));

            progressList.add(progress);
        }

        return progressList;
    }
}
