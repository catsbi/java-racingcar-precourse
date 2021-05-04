package racingcar.view;

import racingcar.domain.GameHistories;
import racingcar.exceptions.InvalidNameException;
import racingcar.exceptions.InvalidRoundException;

import java.util.List;

public class ViewImpl implements View{
    public static final String REQUIRED_VALID_NUMBER = "1이상의 정수를 입력해주세요.";
    public static final int NAME_LIMIT_SIZE = 5;
    public static final String REQUIRED_VALID_CAR_NAME = "자동차의 이름은 5글자 이하만 가능합니다.";
    private final InputView inputView;
    private final OutputView outputView;

    public ViewImpl(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public int questionRound() {
        try {
            int round = inputView.questionRound();
            validateInputRound(round);

            return round;
        } catch (NumberFormatException ne) {
            System.out.println(REQUIRED_VALID_NUMBER);
            return questionRound();
        }
    }

    private void validateInputRound(int round) {
        if (round < 1) {
            throw new InvalidRoundException();
        }
    }

    @Override
    public List<String> questionCarNames() {
        try{
            List<String> inputNames = inputView.questionCarNames();
            validateInputNames(inputNames);

            return inputNames;
        }catch(InvalidNameException ie){
            System.out.println(REQUIRED_VALID_CAR_NAME);
            return questionCarNames();
        }
    }

    private void validateInputNames(List<String> inputNames) {
        for (String name : inputNames) {
            validateInputName(name);
        }
    }

    private void validateInputName(String name) {
        if (name.isEmpty() || name.length() > NAME_LIMIT_SIZE) {
            throw new InvalidNameException();
        }
    }

    @Override
    public void renderRacingProcess(GameHistories result) {
        outputView.renderRacingProcess(result);
    }

    @Override
    public void renderWinners(GameHistories result) {
        outputView.renderWinners(result);
    }
}
