package racingcar.validation;

import java.util.Objects;

public class ErrorResponse {
    private final boolean validated;
    private final String message;


    public ErrorResponse(boolean validated, String message) {
        this.validated = validated;
        this.message = message;
    }

    public static ErrorResponse from(String message) {
        if (Objects.nonNull(message) && !message.isEmpty()) {
            return new ErrorResponse(false, message);
        }
        return new ErrorResponse(true, message);
    }

    public boolean isValidated() {
        return validated;
    }

    public String getMessage() {
        return message;
    }
}
