package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputViewImpl implements InputView{
    private static final InputView instance = new InputViewImpl();
    public static final String QUESTION_OF_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String QUESTION_OF_PLAY_ROUND = "시도할 횟수는 몇회인가요?";
    public static final String DELIMITER = ",";
    private final Scanner scanner;

    private InputViewImpl() {
        this.scanner = new Scanner(System.in);
    }

    public static InputView getInstance() {
        return instance;
    }

    @Override
    public int questionRound() {
        System.out.println(QUESTION_OF_PLAY_ROUND);

        return scanner.nextInt();
    }

    @Override
    public List<String> questionCarNames() {
        System.out.println(QUESTION_OF_CAR_NAMES);

        String inputString = scanner.nextLine();

        return Arrays.asList(inputString.split(DELIMITER));
    }
}
