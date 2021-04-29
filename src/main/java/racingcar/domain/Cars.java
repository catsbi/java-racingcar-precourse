package racingcar.domain;

import racingcar.strategy.CarGenerator;
import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars{
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> list, CarGenerator generator){
        Cars cars = new Cars();

        for (String name : list) {
            cars.appendCar(generator.generate(name));
        }

        return cars;
    }

    public void appendCar(Car car) {
        if (!cars.contains(car)) {
            cars.add(car);
        }
    }

    public boolean containsAll(List<Car> cars) {
        return this.cars.containsAll(cars);
    }

    public void notifyAllMove(MoveStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public int size() {
        return cars.size();
    }
}
