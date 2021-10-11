package racingcar.validation;

import racinggame.exception.InvalidDistanceException;

public class DistanceValidator implements Validator{

    public static final String EMPTY_STR = "";

    @Override
    public String validate(Object source) {
        long distance = (long) source;

        if (distance >= 0) {
            return EMPTY_STR;
        }

        return String.format(InvalidDistanceException.DEFAULT_MESSAGE_FORMAT, distance);
    }
}
