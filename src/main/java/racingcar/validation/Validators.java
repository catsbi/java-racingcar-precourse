package racingcar.validation;

import racinggame.exception.NotFoundValidatorException;
import racinggame.exception.ParameterNullPointException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Validators {
    private static final Map<Class<?>, Validator> store = new HashMap<>();

    private Validators() {}

    public static void addValidator(Class<?> type, Validator validator) {
        store.put(type, validator);
    }

    public static ErrorResponse validate(Object value, Class<?> type) {
        if (Objects.isNull(value)) {
            return ErrorResponse.from(ParameterNullPointException.DEFAULT_MESSAGE);
        }
        if (!store.containsKey(type)) {
            return  ErrorResponse.from(NotFoundValidatorException.DEFAULT_MESSAGE);
        }

        final Validator validator = store.get(type);

        return ErrorResponse.from(validator.validate(value));
    }


}
