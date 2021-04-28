package racingcar.exceptions;

public class InvalidPointException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "위치는 0 이상의 양수여야 합니다.";

    public InvalidPointException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidPointException(String message) {
        super(message);
    }
}
