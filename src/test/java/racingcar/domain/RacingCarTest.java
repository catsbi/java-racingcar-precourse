package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exceptions.InvalidNameException;
import racingcar.fakeobject.TestTargetMoveStrategy;
import racingcar.strategy.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("RacingCar 클래스")
class RacingCarTest {


    @DisplayName("자동차 객체 생성 테스트")
    @ParameterizedTest(name = "{index} {0}이름으로 Car객체 생성")
    @ValueSource(strings = {"power", "crong", "pobi" })
    void create_car_test(String inputCarName) {
        //when
        RacingCar car = new RacingCar(inputCarName);

        //then
        assertThat(car.getName()).isEqualTo(new CarName(inputCarName));
    }

    @DisplayName("자동차 객체 생성 실패 테스트 - 이름을 5글자 초과되게 짓는다.")
    @ParameterizedTest(name = "자동차이름을 {0}으로 생성하면 예외 발생")
    @NullAndEmptySource
    @ValueSource(strings = {"hansol", "catsbi"})
    void create_car_exception_text(String inputCarName) {
        //when, then
        assertThatThrownBy(()->{
            RacingCar car = new RacingCar(inputCarName);
        }).isInstanceOf(InvalidNameException.class);
    }

    @DisplayName("자동차 전진 테스트")
    @ParameterizedTest(name = "{index}생성숫자가 {0}일 때 이동거리는 {1}이다")
    @CsvSource(value = {"1:0", "2:0", "3:0", "4:1", "5:1"}, delimiter = ':')
    void moveTest(int number, int inputPoint) {
        //given
        MoveStrategy moveStrategy = TestTargetMoveStrategy.testTargetMoveStrategy;
        ((TestTargetMoveStrategy)moveStrategy).setTargetCount(number);
        Car testCar = new RacingCar("test");

        //when
        testCar.move(moveStrategy);

        //then
        assertThat(testCar.getCurrentPoint()).isEqualTo(new Point(inputPoint));
    }

}
