package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> list) {
        return new Cars(list);
    }

    public boolean containsAll(List<Car> cars) {
        return this.cars.containsAll(cars);
    }
}
