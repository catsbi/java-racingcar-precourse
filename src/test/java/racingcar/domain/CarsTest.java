package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.CarGenerator;
import racingcar.strategy.RacingCarGenerator;

import java.util.Arrays;
import java.util.List;

@DisplayName("자동차 일급 콜렉션 객체 테스트")
class CarsTest {
    private CarGenerator carGenerator;

    @BeforeEach
    void setup() {
        carGenerator = new RacingCarGenerator();
    }

    @DisplayName("콜렉션 생성 테스트")
    @Test
    void create_Cars_test(){
        //given
        List<String> names =Arrays.asList("crong", "pobi", "bbo");

        //when
        Cars cars = Cars.of(names, carGenerator);

        //then

    }


}
