package racinggame.domain;

import racinggame.strategy.MoveStrategy;

/**
 * 경주용 자동차 정보
 */
public class RacingCar implements Car {
    public static final long MOVE_DISTANCE = 1;

    private final Name name;
    private final Distance distance;

    public RacingCar(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static RacingCar of(String name, long distance) {
        return new RacingCar(Name.from(name), Distance.from(distance));
    }

    @Override
    public Distance getDistance() {
        return distance;
    }

    @Override
    public Name getName() {
        return name;
    }

    public void move(MoveStrategy strategy) {
        if (strategy.movable()) {
            distance.changeWith(MOVE_DISTANCE);
        }
    }
}
