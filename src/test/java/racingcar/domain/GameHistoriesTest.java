package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.Winners;
import racingcar.exceptions.InvalidParameterException;
import racingcar.fakeobject.TestMoveStrategy;
import racingcar.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차경주 기록 일급 콜렉션 테스트")
class GameHistoriesTest {
    private GameHistories gameHistories;
    private GameHistory firstHistory;
    private GameHistory secondHistory;

    private Car crongCar;
    private Car pobiCar;
    private Car bboCar;

    @BeforeEach
    void setup() {
        final MoveStrategy moveStrategy = TestMoveStrategy.alwaysTrueMoveStrategy;

        gameHistories = new GameHistories();
        crongCar = new RacingCar(new CarName("crong"), new Point(3));
        pobiCar = new RacingCar(new CarName("pobi"), new Point(4));
        bboCar = new RacingCar(new CarName("bbo"), new Point(5));

        Cars cars = new Cars(Arrays.asList(crongCar, pobiCar, bboCar));

        firstHistory = GameHistory.from(cars);
        gameHistories.appendHistory(firstHistory);

        cars.notifyAllMove(moveStrategy);
        secondHistory = GameHistory.from(cars);
    }


    @DisplayName("게임 기록 추가 메서드 테스트")
    @Test
    void appendHistory_test() {
        //when
        gameHistories.appendHistory(secondHistory);

        //then
        GameHistory lastHistory = gameHistories.lastHistory();
        assertThat(gameHistories.size()).isEqualTo(2);
        assertThat(lastHistory).isEqualTo(secondHistory);

    }

    @DisplayName("자동차 경주 기록의 값을 추출하면 GameHistory 리스트 콜렉션이 반환된다.")
    @Test
    void values_test() {
        //given
        gameHistories.appendHistory(secondHistory);

        //when
        List<GameHistory> values = gameHistories.values();

        //then
        assertThat(values).hasSize(2);
        assertThat(values).containsAll(Arrays.asList(firstHistory, secondHistory));
    }

    @DisplayName("자동차 경주 기록의 마지막 값 추출 테스트")
    @Test
    void lastHistory_test() {
        //given
        GameHistory currentLastHistory = gameHistories.lastHistory();
        gameHistories.appendHistory(secondHistory);

        //when
        GameHistory resultLastHistory = gameHistories.lastHistory();

        //then
        assertThat(currentLastHistory).isNotEqualTo(resultLastHistory);
        assertThat(currentLastHistory).isEqualTo(firstHistory);
        assertThat(resultLastHistory).isEqualTo(secondHistory);
    }

    @DisplayName("자동차 경주 기록에서 원하는 인덱스의 기록을 가져올 수 있다.")
    @Test
    void get_test() {
        //given
        gameHistories.appendHistory(secondHistory);

        //when
        GameHistory firstFindHistory = gameHistories.get(0);
        GameHistory secondFindHistory = gameHistories.get(1);

        //then
        assertThat(firstFindHistory).isEqualTo(firstHistory);
        assertThat(secondFindHistory).isEqualTo(secondHistory);

    }

    @DisplayName("자동차 경주 기록에서 유효하지 않은 위치의 값을 조회할 수 없다.")
    @ParameterizedTest(name = "인덱스 {0}의 값은 조회할수 없다.")
    @ValueSource(ints = {-1, 3})
    void get_exception_test(int inputIndex) {
        //given
        gameHistories.appendHistory(secondHistory);

        //when, then
        assertThatThrownBy(() -> {
            gameHistories.get(inputIndex);
        }).isInstanceOf(InvalidParameterException.class);

    }


    @DisplayName("자동차 경주 기록 최종 우승자 조회 테스트")
    @Test
    void getWinners_test() {
        //given
        gameHistories.appendHistory(secondHistory);

        //when
        Winners winners = gameHistories.getWinners();

        //then
        assertThat(winners.getNames()).hasSize(1);
        assertThat(winners.getNames()).containsExactly(bboCar.getName());
    }
}
