package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class RacingCar implements Car{
    public static final int ADDED_POINT = 1;
    private CarName name;
    private Point point;

    public RacingCar(String name) {
        this.name = new CarName(name);
        this.point = new Point();
    }

    @Override
    public CarName getName() {
        return name;
    }

    @Override
    public void move(MoveStrategy strategy) {
        if (allowMove(strategy)) {
            point.addPoint(ADDED_POINT);
        }
    }

    private boolean allowMove(MoveStrategy strategy) {
        return strategy.execute();
    }

    @Override
    public Point getCurrentPoint() {
        return point;
    }
}
