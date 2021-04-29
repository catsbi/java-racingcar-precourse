package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Point;

public class CarResponse {
    private final CarName name;
    private final Point point;

    public CarResponse(CarName name, Point point) {
        this.name = name;
        this.point = point;
    }

    public static CarResponse from(Car car) {
        return new CarResponse(car.getName(), copyPoint(car.getCurrentPoint()));
    }

    private static Point copyPoint(Point currentPoint) {
        return new Point(currentPoint.getPoint());
    }

    public CarName getName() {
        return name;
    }

    public Point getPoint() {
        return point;
    }

    public int getPrimitivePoint() {
        return point.getPoint();
    }
}
