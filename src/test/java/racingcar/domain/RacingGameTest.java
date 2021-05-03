package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.fakeobject.TestMoveStrategy;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RacingCarGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 경주 게임 진행 테스트")
public class RacingGameTest {
    private MoveStrategy onlyMoveStrategy;
    private MoveStrategy onlyStopStrategy;
    private RacingGame racingGame;
    private List<String> carList;

    @BeforeEach
    void setup() {
        onlyMoveStrategy = new TestMoveStrategy(4);
        onlyStopStrategy = new TestMoveStrategy(3);
        carList = Arrays.asList("crong","pobi","bbo");

        racingGame = new RacingGameImpl(new RacingCarGenerator(), onlyMoveStrategy);

        racingGame.appendCar(carList);
    }

    @DisplayName("자동차 경주에 자동차 객체 참가 테스트")
    @ParameterizedTest(name = "이름 {0}으로 참가")
    @ValueSource(strings = {"crong", "pobi", "bbo"})
    void appendCar_test(String inputName) {
        //when
        racingGame.appendCar(new RacingCar(inputName));

        //then
        assertThat(racingGame.containsCar(new RacingCar(inputName))).isTrue();
    }

    @DisplayName("게임 진행을 하면 진행 횟수(Round)만큼 각각의 자동차는 전진(혹은 정지)을 한다.")
    @Test
    void play_test() {
        //when
        racingGame.play(new Round(5));

        //then
        GameHistories result = racingGame.getResult();
        List<CarName> names = result.getWinners().getNames();
        for (String name : carList) {
            assertThat(names).contains(new CarName(name));
        }
    }



}
