package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.fakeobject.TestMoveStrategy;
import racingcar.strategy.MoveStrategy;

import java.util.List;

@DisplayName("자동차 경주 비즈니스 로직 테스트")
class RacingGameServiceTest {
    private RacingGameService racingGameService;
    private MoveStrategy moveStrategy;

    @BeforeEach
    void setup() {
        moveStrategy = new TestMoveStrategy(4);
        racingGameService = new RacingGameService(moveStrategy);
    }

    @DisplayName("입력받은 횟수만큼 모든 자동차를 전진(혹은 정지) 하도록 해야한다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,bbo"}, delimiter = ',')
    void game_start_test(List<String> inputNames) {
        //given

        //when

        //then

    }
}
