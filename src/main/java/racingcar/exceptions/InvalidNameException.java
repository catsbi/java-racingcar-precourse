package racingcar.exceptions;

public class InvalidNameException extends RuntimeException{
    public static final String DEFAULT_MESSAGE = "자동차 이름은 공백이 아니고 5글자 이하여야 합니다.";

    public InvalidNameException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidNameException(String message) {
        super(message);
    }
}
