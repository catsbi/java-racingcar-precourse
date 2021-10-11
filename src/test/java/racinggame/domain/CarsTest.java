package racinggame.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.validation.DistanceValidator;
import racingcar.validation.NameValidator;
import racingcar.validation.Validators;
import racinggame.dto.CarData;
import racinggame.strategy.MoveStrategy;
import racinggame.strategy.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

@DisplayName("Cars 클래스")
class CarsTest {
    private static MockedStatic<Randoms> mRandoms;
    private MoveStrategy moveStrategy;
    private List<Car> carList;

    @BeforeAll
    public static void beforeClass() {
        mRandoms = mockStatic(Randoms.class);
    }

    @AfterAll
    public static void afterClass() {
        mRandoms.close();
    }

    @BeforeEach
    void setUp() {
        moveStrategy = new RandomMoveStrategy();
        Validators.addValidator(Name.class, new NameValidator());
        Validators.addValidator(Distance.class, new DistanceValidator());

        carList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            carList.add(RacingCar.of("test" + i, 0));
        }
    }


    @DisplayName("from 메서드는 자동차 목록을 모두 저장한 뒤, 인스턴스를 반환한다. ")
    @Test
    void fromWithCarList() {

        final Cars cars = Cars.from(carList);

        for (Car car : carList) {
            assertThat(cars.contains(car)).isTrue();
        }
    }

    @DisplayName("addAll 메서드는 자동차 목록을 한 번에 추가할 수 있다. ")
    @Test
    void addAllWithCarList() {
        final Cars cars = Cars.newInstance();

        cars.addAll(carList);

        for (Car car : carList) {
            assertThat(cars.contains(car)).isTrue();
        }
    }

    @DisplayName("add 메서드는 자동차를 하나씩 추가할 수 있다.")
    @Test
    void addWithCar() {
        final Cars cars = Cars.newInstance();

        for (Car car : carList) {
            assertThat(cars.contains(car)).isFalse();

            cars.add(car);
            assertThat(cars.contains(car)).isTrue();
        }
    }

    @DisplayName("map 메서드는 자동차 목록을 자동차 DTO 목록으로 변경할 수 있다. ")
    @Test
    void mapWithConvertor() {
        final Cars cars = Cars.from(carList);

        final List<CarData> carDataList = cars.map(CarData::from);

        assertThat(carDataList).hasSize(carList.size());
    }


    @DisplayName("notifyAll 메서드로 목록 내 자동차들을 순회하며 동작을 제어할 수 있다.")
    @Test
    void notifyAllCars() {
        given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(4);
        final Cars cars = Cars.from(carList);

        cars.notifyAll(car -> assertThat(car.getDistance()).isEqualTo(Distance.from(0)));
        cars.notifyAll(car -> car.move(moveStrategy));
        cars.notifyAll(car -> assertThat(car.getDistance()).isEqualTo(Distance.from(1)));
    }
}
