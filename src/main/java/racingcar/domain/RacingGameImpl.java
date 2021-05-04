package racingcar.domain;

import racingcar.strategy.CarGenerator;
import racingcar.strategy.MoveStrategy;

import java.util.List;

public class RacingGameImpl implements RacingGame {

    private final Cars cars;
    private final CarGenerator generator;
    private final MoveStrategy moveStrategy;
    private final GameHistories gameHistories;

    public RacingGameImpl(CarGenerator generator, MoveStrategy moveStrategy) {
        this.generator = generator;
        this.moveStrategy = moveStrategy;
        this.cars = new Cars();
        this.gameHistories = new GameHistories();
    }

    @Override
    public void appendCar(Car car) {
        this.cars.appendCar(car);
    }

    @Override
    public void appendCar(String name) {
        this.cars.appendCar(generator.generate(name));
    }

    @Override
    public void appendCar(List<String> names) {
        for (String name : names) {
            appendCar(name);
        }
    }

    @Override
    public boolean containsCar(Car car) {
        return cars.contains(car);
    }

    @Override
    public void play(int round) {
        for (int index = 0; index < round; index++) {
            cars.notifyAllMove(moveStrategy);
            record();
        }
    }

    private void record() {
        gameHistories.appendHistory(GameHistory.from(cars));
    }

    @Override
    public GameHistories getResult() {
        return gameHistories;
    }

}
