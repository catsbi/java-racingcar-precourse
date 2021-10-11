package racinggame.dto;

import racinggame.exception.OutOfIndexException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class CarRacingProgress {
    private final List<CarData> store;

    public CarRacingProgress() {
        store  = new ArrayList<>();
    }

    public static CarRacingProgress from(List<CarData> carDataList) {
        final CarRacingProgress progress = new CarRacingProgress();
        progress.addAll(carDataList);

        return progress;
    }

    public void addAll(List<CarData> carDataList) {
        store.addAll(carDataList);
    }

    public void notifyAll(Consumer<CarData> consumer) {
        for (CarData data : store) {
            consumer.accept(data);
        }
    }

    public <T> List<T> map(Function<CarData, T> function) {
        List<T> list = new ArrayList<>();

        for (CarData data : store) {
            list.add(function.apply(data));
        }

        return list;
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
}
