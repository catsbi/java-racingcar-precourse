package racinggame.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class CarRacingProgress {
    private final List<CarData> store = new ArrayList<>();

    public CarRacingProgress() {}

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
}
