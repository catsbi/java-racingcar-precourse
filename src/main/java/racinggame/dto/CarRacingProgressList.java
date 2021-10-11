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

    public <T> List<T> map(Function<CarRacingProgress, T> function) {
        List<T> list = new ArrayList<>();
        for (CarRacingProgress progress : store) {
            list.add(function.apply(progress));
        }

        return list;
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
            resultStr = resultStr.concat(progress.toString(function));
        }

        return resultStr;
    }

    public int size() {
        return store.size();
    }
}
