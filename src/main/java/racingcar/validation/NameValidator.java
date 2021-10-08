package racingcar.validation;

import racinggame.exception.InvalidNameException;

import java.util.Objects;

public class NameValidator implements Validator<String, String>{

    public static final String EMPTY_STR = "";

    @Override
    public String validate(String source) {
        if (Objects.nonNull(source) && source.length() < 6) {
            return EMPTY_STR;
        }

        return String.format(InvalidNameException.DEFAULT_MESSAGE_FORMAT, source);
    }
}
