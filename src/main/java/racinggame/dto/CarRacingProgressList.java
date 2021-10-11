package racinggame.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CarRacingProgressList {
    private final List<CarRacingProgress> store = new ArrayList<>();

    public CarRacingProgressList() {}

    public static CarRacingProgressList from(List<CarRacingProgress> list) {
        final CarRacingProgressList progressList = new CarRacingProgressList();

        progressList.addAll(list);

        return progressList;
    }

    private void addAll(List<CarRacingProgress> list) {
        store.addAll(list);
    }

    public StringBuilder toString(Function<CarRacingProgress, String> function, StringBuilder sb) {
        for (CarRacingProgress progress : store) {
            final String result = function.apply(progress);
            sb.append(result).append(System.lineSeparator());
        }

        return sb;
    }
}
