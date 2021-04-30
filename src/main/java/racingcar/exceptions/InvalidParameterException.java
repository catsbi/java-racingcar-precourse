package racingcar.exceptions;

public class InvalidParameterException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = "유효하지 않은 파라미터 입니다.";

    public InvalidParameterException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidParameterException(String message) {
        super(message);
    }
}
