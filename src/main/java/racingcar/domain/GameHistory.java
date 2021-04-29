package racingcar.domain;

import racingcar.dto.CarResponse;
import racingcar.dto.Winners;

import java.util.HashMap;
import java.util.Map;

public class GameHistory {
    private final Map<CarName, CarResponse> history;


    public GameHistory(Map<CarName, CarResponse> history) {
        this.history = history;
    }

    public static GameHistory from(Cars cars) {
        return new GameHistory(toCarResponses(cars, new HashMap<>()));
    }

    private static Map<CarName, CarResponse> toCarResponses(Cars cars, Map<CarName, CarResponse> history) {
        for (int index = 0; index < cars.size(); index++) {
            Car car = cars.get(index);
            history.put(car.getName(), CarResponse.from(car));
        }

        return history;
    }

    public int size() {
        return history.size();
    }

    public Point getPoint(CarName name) {
        return history.get(name).getPoint();
    }

    public Winners getWinners() {
        Point maxPoint = getMaxPoint();

        return findNamesByPoint(maxPoint);
    }

    private Winners findNamesByPoint(Point maxPoint) {
        Map<Point, Winners> groupMap = groupByPoint();

        return groupMap.get(maxPoint);
    }

    private Map<Point, Winners> groupByPoint() {
        Map<Point, Winners> winnersMap = new HashMap<>();
        for (CarResponse response : history.values()) {
            Winners winners = winnersMap.getOrDefault(response.getPoint(), new Winners());
            winners.append(response.getName());

            winnersMap.put(response.getPoint(), winners);
        }
        return winnersMap;
        
    }

    private Point getMaxPoint() {
        Point currentMaxPoint = Point.ZERO_POINT;
        for (CarResponse current : history.values()) {
            currentMaxPoint = compareMax(currentMaxPoint, current.getPoint());
        }

        return currentMaxPoint;
    }

    private Point compareMax(Point sourcePoint, Point targetPoint) {
        if (sourcePoint.isGreaterOrEqual(targetPoint)) {
            return sourcePoint;
        }
        return targetPoint;
    }
}
