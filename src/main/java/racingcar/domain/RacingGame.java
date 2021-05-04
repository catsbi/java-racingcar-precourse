package racingcar.domain;

import java.util.List;

public interface RacingGame {

    void appendCar(Car car);

    void appendCar(String car);

    void appendCar(List<String> names);

    boolean containsCar(Car car);

    void play(int round);

    GameHistories getResult();
}
