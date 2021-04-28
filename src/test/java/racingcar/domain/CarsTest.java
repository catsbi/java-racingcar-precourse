package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("자동차 일급 콜렉션 객체 테스트")
class CarsTest {

    @DisplayName("콜렉션 생성 테스트")
    @Test
    void create_Cars_test() {
        //given
        final String CRONG = "crong";
        final String POBI = "pobi";
        final String BBO = "bbo";

        List<Car> carList = Arrays.asList(new RacingCar(CRONG), new RacingCar(POBI), new RacingCar(BBO));

        //when
        Cars cars = Cars.of(carList);

        //then
        assertThat(cars.containsAll(carList)).isTrue();
    }

}
