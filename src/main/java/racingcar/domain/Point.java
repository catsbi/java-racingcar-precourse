package racingcar.domain;

import racingcar.exceptions.InvalidPointException;

import java.util.Objects;

public class Point {
    public static final int INIT_POINT = 0;
    private int point;

    public Point() {
        this(INIT_POINT);
    }

    public Point(int point) {
        validatePoint(point);
        this.point = point;
    }

    private void validatePoint(int point) {
        if (point < 0) {
            throw new InvalidPointException();
        }
    }

    public int getPoint() {
        return point;
    }

    public void addPoint(int addedPoint) {
        point += addedPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point1 = (Point) o;
        return point == point1.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
