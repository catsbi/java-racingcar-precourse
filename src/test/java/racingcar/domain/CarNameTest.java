package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exceptions.InvalidNameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 이름 Wrapper Class 테스트")
class CarNameTest {

    @DisplayName("이름 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"t", "te", "tes", "test", "testC"})
    void create_carName_test(String inputName) {
        //when
        CarName carName = new CarName(inputName);

        //then
        assertThat(carName).isNotNull();
        assertThat(carName.getName()).isEqualTo(inputName);
    }

    @DisplayName("이름 생성 실패 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"testCa", "testCar"})
    void create_carName_exception_test(String inputName) {
        //when, then
        assertThatThrownBy(()->{
            new CarName(inputName);
        }).isInstanceOf(InvalidNameException.class);
    }

}
