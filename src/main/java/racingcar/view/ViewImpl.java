package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Round;
import racingcar.dto.GameResultResponse;

import java.util.List;

public class ViewImpl implements View{

    @Override
    public Round questionRound() {
        return null;
    }

    @Override
    public List<Car> questionCarNames() {
        return null;
    }

    @Override
    public void renderRacingProcess(GameResultResponse response) {

    }

    @Override
    public void renderWinners(GameResultResponse response) {

    }
}
