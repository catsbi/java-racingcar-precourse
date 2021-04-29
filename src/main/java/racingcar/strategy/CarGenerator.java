package racingcar.strategy;

import racingcar.domain.Car;

@FunctionalInterface
public interface CarGenerator {
    Car generate(String name);
}
