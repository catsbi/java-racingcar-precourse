package racingcar.domain;

import racingcar.dto.CarResponse;
import racingcar.dto.Winners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        Map<Point, List<CarName>> groupMap = groupByPoint();
        List<CarName> names = groupMap.get(maxPoint);

        return new Winners(names);
    }

    private Map<Point, List<CarName>> groupByPoint() {
        Map<Point, List<CarName>> groupMap = new HashMap<>();
        for (CarResponse response : history.values()) {
            List<CarName> list = groupMap.getOrDefault(response.getPoint(), new ArrayList<>());
            addWithoutDuplicate(list, response.getName());

            groupMap.put(response.getPoint(), list);
        }

        return groupMap;
    }

    private void addWithoutDuplicate(List<CarName> list, CarName name) {
        if (!list.contains(name)) {
            list.add(name);
        }
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
