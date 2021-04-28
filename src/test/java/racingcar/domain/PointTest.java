package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exceptions.InvalidPointException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Point Wrapper class 테스트")
class PointTest {

    @DisplayName("유효한 범위의 위치 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1,2,3,4,5,6,7,8,9})
    void create_point_test(int inputPoint) {
        //when
        Point point = new Point(inputPoint);

        //then
        assertThat(point.getPoint()).isEqualTo(inputPoint);
    }

    @DisplayName("유효하지 않음 범위의 위치 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-2, -1})
    void create_point_exception_test(int inputPoint) {
        assertThatThrownBy(()->{
            new Point(inputPoint);
        }).isInstanceOf(InvalidPointException.class);
    }

    @DisplayName("위치 증가 메소드 테스트")
    @ParameterizedTest
    @MethodSource("providePointAndSummery")
    void addPoint_test(List<Integer> inputPoints, Point resultPoint) {
        //given
        Point point = new Point();

        //when
        for (Integer inputPoint : inputPoints) {
            point.addPoint(inputPoint);
        }

        //then
        assertThat(point).isEqualTo(resultPoint);
    }

    private static Stream<Arguments> providePointAndSummery() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3), new Point(6)),
                Arguments.of(Arrays.asList(4,5,6), new Point(15)),
                Arguments.of(Arrays.asList(2,4,6), new Point(12))
        );
    }
}
