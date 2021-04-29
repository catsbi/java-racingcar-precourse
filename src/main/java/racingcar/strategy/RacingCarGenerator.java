package racingcar.strategy;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;

public class RacingCarGenerator implements CarGenerator{

    @Override
    public Car generate(String name) {
        return new RacingCar(name);
    }
}
