package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.Winners;
import racingcar.fakeobject.TestMoveStrategy;
import racingcar.strategy.MoveStrategy;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차경주 기록 저장 객체 기능 테스트")
class GameHistoryTest {
    private MoveStrategy moveStrategy;

    private Car crongCar;
    private Car pobiCar;
    private Car bboCar;
    private Car pengCar;

    private Cars cars;

    @BeforeEach
    void setup() {
        moveStrategy = new TestMoveStrategy(4);

        crongCar = new RacingCar(new CarName("crong"), new Point(3));
        pobiCar = new RacingCar(new CarName("pobi"), new Point(4));
        bboCar = new RacingCar(new CarName("bbo"), new Point(5));
        pengCar = new RacingCar(new CarName("peng"), new Point(5));

        cars = new Cars(Arrays.asList(crongCar, pobiCar, bboCar, pengCar));
    }

    @DisplayName("자동차경주 기록 객체 생성 테스트")
    @Test
    void from_test() {
        //when
        GameHistory firstGameHistory = GameHistory.from(cars);
        cars.notifyAllMove(moveStrategy);
        GameHistory secondGameHistory = GameHistory.from(cars);

        //then
        assertThat(firstGameHistory.size()).isEqualTo(4);
        assertThat(secondGameHistory.size()).isEqualTo(4);

        assertThat(firstGameHistory.getPoint(bboCar.getName())).isEqualTo(new Point(5));
        assertThat(secondGameHistory.getPoint(pobiCar.getName())).isEqualTo(new Point(5));

    }

    @DisplayName("자동차 경주 기록의 크기는 항상 최초 생성시 참가한 자동차의 크기이다.")
    @Test
    void size_test() {
        //when, then
        for (int i = 0; i < 10; i++) {
            GameHistory gameHistory = GameHistory.from(cars);
            assertThat(gameHistory.size()).isEqualTo(4);

            cars.notifyAllMove(moveStrategy);
        }
    }

    @DisplayName("자동차 경주 기록에서 특정 자동차의 이동거리는 자동차가 더 이동하더라도 변하지 않는다.")
    @Test
    void getPoint_test() {
        //when
        GameHistory gameHistory = GameHistory.from(cars);
        cars.notifyAllMove(moveStrategy);

        //then
        assertThat(gameHistory.getPoint(crongCar.getName())).isEqualTo(new Point(3));

    }

    @DisplayName("우승자는 가장 이동거리가 많은 사람이 나오며 여러명이 나올수도 있다.")
    @Test
    void getWinners_test() {
        //given
        GameHistory gameHistory = GameHistory.from(cars);
        Cars threeCars = new Cars(Arrays.asList(pengCar, crongCar, pobiCar));
        GameHistory threeCarsGameHistory = GameHistory.from(threeCars);

        //when
        Winners winners1 = gameHistory.getWinners();
        Winners winners2 = threeCarsGameHistory.getWinners();

        //then
        assertThat(winners1.size()).isEqualTo(2);
        assertThat(winners1.getNames()).containsOnly(bboCar.getName(), pengCar.getName());

        assertThat(winners2.size()).isEqualTo(1);
        assertThat(winners2.getNames()).containsOnly(pengCar.getName());




    }
}
