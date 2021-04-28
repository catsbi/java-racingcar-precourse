package racingcar.exceptions;

public class InvalidRoundException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "유효한 라운드 숫자가 아닙니다.";

    public InvalidRoundException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidRoundException(String message) {
        super(message);
    }
}
