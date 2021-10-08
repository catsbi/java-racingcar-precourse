package racingcar.validation;

import racinggame.exception.InvalidDistanceException;

import java.util.Objects;

public class DistanceValidator implements Validator<Integer, String>{

    public static final String EMPTY_STR = "";

    @Override
    public String validate(Integer source) {
        if (Objects.nonNull(source) && source >= 0) {
            return EMPTY_STR;
        }

        return String.format(InvalidDistanceException.DEFAULT_MESSAGE_FORMAT, source);
    }
}
