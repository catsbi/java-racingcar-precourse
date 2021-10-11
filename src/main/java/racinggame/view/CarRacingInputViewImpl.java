package racinggame.view;

import nextstep.utils.Console;
import racingcar.validation.Validators;
import racinggame.domain.Cars;
import racinggame.domain.Name;

public class CarRacingInputViewImpl implements CarRacingInputView {
    public static final String ERROR_PREFIX = "[ERROR]";

    @Override
    public String requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String names = Console.readLine();
        final String message = nameValidateResult(names);

        if (!message.isEmpty()) {
            System.out.println(ERROR_PREFIX + message);
            return requestCarNames();
        }

        return names;
    }

    private String nameValidateResult(String names) {
        final StringBuilder sb = new StringBuilder();

        for (String splitName : names.split(Cars.DELIMITER)) {
            sb.append(Validators.validate(splitName, Name.class).getMessage());
        }
        return sb.toString();
    }

    @Override
    public int requestRound() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            final String roundStr = Console.readLine();

            return Integer.parseInt(roundStr);

        } catch (NumberFormatException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return requestRound();
        }
    }
}
