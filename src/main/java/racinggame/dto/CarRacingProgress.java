package racinggame.dto;

import racinggame.exception.OutOfIndexException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CarRacingProgress {
    public static final String DELIMITER = ",";
    private final List<CarData> store;

    public CarRacingProgress() {
        store = new ArrayList<>();
    }

    public static CarRacingProgress from(List<CarData> carDataList) {
        final CarRacingProgress progress = new CarRacingProgress();
        progress.addAll(carDataList);

        return progress;
    }

    public void addAll(List<CarData> carDataList) {
        store.addAll(carDataList);
    }

    public CarData get(int index) {
        if (index < 0 || index >= store.size()) {
            throw new OutOfIndexException(index);
        }

        return store.get(index);
    }

    public String toString(Function<CarData, String> function) {
        String progressStr = "";
        for (CarData carData : store) {
            progressStr = progressStr.concat(function.apply(carData));
        }

        return progressStr;
    }

    public int size() {
        return store.size();
    }

    public String getWinners() {
        long maxDistance = 0;
        Map<Long, String> winnersMap = new HashMap<>();

        for (CarData carData : store) {
            maxDistance = Math.max(carData.getDistance(), maxDistance);
            winnersMap.merge(carData.getDistance(), carData.getName(), (name, putName) -> name.concat(DELIMITER + putName));
        }

        return winnersMap.get(maxDistance);
    }
}
