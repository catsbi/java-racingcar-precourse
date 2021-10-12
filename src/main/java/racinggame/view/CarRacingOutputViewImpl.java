package racinggame.view;

import racinggame.dto.CarData;
import racinggame.dto.CarRacingProgress;
import racinggame.dto.CarRacingResultData;

import java.util.List;

public class CarRacingOutputViewImpl implements CarRacingOutputView {
    private static final StringBuilder sb = new StringBuilder();
    public static final String FINAL_WINNERS_FORMAT = "최종 우승자는 %s 입니다.";

    @Override
    public void drawRacingProgress(CarRacingResultData resultData) {
        clearStringBuilder();

        drawRacingProgressList(resultData.getProgressList());
        drawRacingWinners(resultData.getWinners());
    }

    private void drawRacingProgressList(List<CarRacingProgress> progressList) {
        for (CarRacingProgress progress : progressList) {
            sb.append(progress.toString(this::drawRacingCarData))
                    .append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private void drawRacingWinners(List<String> winnerNames) {
        clearStringBuilder();
        final String winners = String.join(",", winnerNames);

        sb.append(String.format(FINAL_WINNERS_FORMAT, winners));
        System.out.println(sb);
    }

    private String drawRacingCarData(CarData carData) {
        return String.format("%s : %s", carData.getName(), makeDistance(carData.getDistance()));
    }

    private String makeDistance(long distance) {
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    private void clearStringBuilder() {
        sb.replace(0, sb.length(), "");
    }
}
