package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 자동차
 */
public class Cars {
    private final List<Car> store = new ArrayList<>();

    private Cars() {}

    public static Cars newInstance() {
        return new Cars();
    }

    public static Cars from(List<Car> carList) {
        final Cars cars = newInstance();
        cars.addAll(carList);

        return cars;
    }

    public void addAll(List<Car> carList) {
        store.addAll(carList);
    }

    public void add(Car car) {
        store.add(car);
    }

    public void notifyAll(Consumer<Car> consumer) {
        for (Car car : store) {
            consumer.accept(car);
        }
    }

    public <T> List<T> map(Function<Car, T> function) {
        List<T> list = new ArrayList<>();

        for (Car car : store) {
            list.add(function.apply(car));
        }

        return list;
    }

    public boolean contains(Car car) {
        return store.contains(car);
    }
}
