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

    /**
     * 자동차 경주를 인자로 전달한 라운드만큼 진행하고 그 결과를 반환한다.
     *
     * @param names 참가할 경주 자동차 이름목록
     * @param round 경주를 진행할 횟수
     * @return 자동차 경주 결과
     */
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
