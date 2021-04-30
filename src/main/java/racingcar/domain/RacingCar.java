package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.Objects;

public class RacingCar implements Car{
    public static final int ADDED_POINT = 1;
    private CarName name;
    private Point point;

    public RacingCar(String name) {
        this(new CarName(name), new Point());
    }

    public RacingCar(CarName name, Point point) {
        this.name = name;
        this.point = point;
    }

    @Override
    public CarName getName() {
        return name;
    }

    @Override
    public void move(MoveStrategy strategy) {
        if (strategy.isMovable()) {
            point.addPoint(ADDED_POINT);
        }
    }

    @Override
    public Point getCurrentPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RacingCar)) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name) && Objects.equals(point, racingCar.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, point);
    }

}
