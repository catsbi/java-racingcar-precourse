package racingcar.view;

import racingcar.domain.CarName;
import racingcar.domain.GameHistories;
import racingcar.domain.GameHistory;
import racingcar.domain.Point;
import racingcar.dto.CarResponse;
import racingcar.dto.Winners;

import java.util.StringJoiner;

public class OutputViewImpl implements OutputView{
    private static final OutputView instance = new OutputViewImpl();

    public static final int ZERO = 0;
    public static final String EMPTY_STR = "";
    public static final String SKID_MARK = "-";
    public static final String WINNERS_DELIMITER = ",";
    public static final String COLON_DELIMITER = " : ";
    public static final String ALERT_GAME_RESULT = "실행 결과";
    public static final String ALERT_WINNERS = "가 최종 우승했습니다.";

    private final StringBuilder sb;

    private OutputViewImpl() {
        sb = new StringBuilder();
    }

    public static OutputView getInstance() {
        return instance;
    }

    @Override
    public void renderRacingProcess(GameHistories result) {
        clearString();
        sb.append(ALERT_GAME_RESULT).append(System.lineSeparator());

        for (int index = 0; index < result.size(); index++) {
            appendResult(result.get(index));
        }

        System.out.println(sb);
    }

    private void appendResult(GameHistory gameHistory) {
        for (CarResponse carResponse : gameHistory.values()) {
            appendResultFromCar(carResponse);
        }
        sb.append(System.lineSeparator());
    }

    private void appendResultFromCar(CarResponse response) {
        Point point = response.getPoint();

        sb.append(response.getName())
                .append(COLON_DELIMITER)
                .append(repeatSkidMark(point))
                .append(System.lineSeparator());
    }

    private String repeatSkidMark(Point point) {
        return new String(new char[point.getPoint()]).replace("\0", SKID_MARK);
    }

    private void clearString() {
        sb.replace(ZERO, sb.length(), EMPTY_STR);
    }

    @Override
    public void renderWinners(GameHistories result) {
        clearString();

        Winners winners = result.getWinners();
        StringJoiner joiner = joiningWinnerNames(winners);

        sb.append(joiner).append(ALERT_WINNERS);

        System.out.println(sb);
    }

    private StringJoiner joiningWinnerNames(Winners winners) {
        StringJoiner joiner = new StringJoiner(WINNERS_DELIMITER);

        for (CarName carName : winners.getNames()) {
            joiner.add(carName.getName());
        }
        return joiner;
    }
}
