package racinggame.view;

import racinggame.dto.CarData;
import racinggame.dto.CarRacingProgressList;

public class CarRacingOutputViewImpl implements CarRacingOutputView {
    private static final StringBuilder sb = new StringBuilder();
    public static final String FINAL_WINNERS_FORMAT = "최종 우승자는 %s 입니다.";

    @Override
    public void drawRacingProgress(CarRacingProgressList progressList) {
        final String result = progressList.toString(this::drawRacingCarData);
        System.out.println(result);

        System.out.println(String.format(FINAL_WINNERS_FORMAT, progressList.getWinners()));
    }

    private String drawRacingCarData(CarData carData) {
        clearStringBuilder();
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
