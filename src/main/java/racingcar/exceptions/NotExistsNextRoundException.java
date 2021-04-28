package racingcar.exceptions;

public class NotExistsNextRoundException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "다음 라운드가 존재하지 않습니다.";

    public NotExistsNextRoundException() {
        super(DEFAULT_MESSAGE);
    }

    public NotExistsNextRoundException(String message) {
        super(message);
    }
}
