package racingcar.validation;

import racinggame.exception.InvalidNameException;

import java.util.Objects;

public class NameValidator implements Validator {
    public static final String EMPTY_STR = "";

    @Override
    public String validate(Object source) {
        final String name = String.valueOf(source);

        if (Objects.nonNull(name)
                && name.length() < 6
                && !name.isEmpty()) {
            return EMPTY_STR;
        }

        return String.format(InvalidNameException.DEFAULT_MESSAGE_FORMAT, name);
    }
}
