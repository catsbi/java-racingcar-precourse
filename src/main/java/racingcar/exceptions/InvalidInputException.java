package racingcar.exceptions;

public class InvalidInputException extends RuntimeException{
    public static final String DEFAULT_MESSAGE = "입력한 값이 유효하지 않습니다. 1 이상의 숫자를 입력해주세요.";

    public InvalidInputException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
