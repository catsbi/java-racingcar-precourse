package racinggame.dto;

import racinggame.exception.OutOfIndexException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CarRacingProgressList {
    private final List<CarRacingProgress> store;

    public CarRacingProgressList() {
        store = new ArrayList<>();
    }

    public static CarRacingProgressList from(List<CarRacingProgress> list) {
        final CarRacingProgressList progressList = new CarRacingProgressList();

        progressList.addAll(list);

        return progressList;
    }

    private void addAll(List<CarRacingProgress> list) {
        store.addAll(list);
    }

    public void add(CarRacingProgress progress) {
        store.add(progress);
    }

    public CarRacingProgress get(int index) {
        if (index < 0 || index >= store.size()) {
            throw new OutOfIndexException(index);
        }
        return store.get(index);
    }

    public String toString(Function<CarData, String> function) {
        String resultStr = "";
        for (CarRacingProgress progress : store) {
            resultStr = resultStr.concat(progress.toString(function)).concat(System.lineSeparator());
        }

        return resultStr;
    }

    public int size() {
        return store.size();
    }

    public String getWinners() {
        final CarRacingProgress lastProgress = store.get(store.size() - 1);

        return lastProgress.getWinners();
    }
}
