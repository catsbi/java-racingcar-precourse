package racinggame.strategy;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

@DisplayName("RandomMoveStrategy 클래스")
class RandomMoveStrategyTest {
    private static MockedStatic<Randoms> mRandoms;
    private MoveStrategy moveStrategy;

    @BeforeAll
    public static void beforeClass() {
        mRandoms = mockStatic(Randoms.class);
    }

    @AfterEach
    void afterClass() {
        mRandoms.close();
    }

    @BeforeEach
    void setUp() {
        moveStrategy = new RandomMoveStrategy();
    }

    @DisplayName("movable 메서드는")
    @Nested
    class Describe_movable {
        @DisplayName("임의의 숫자로 3 이하가 나왔을 경우")
        @Nested
        class Context_with_three_under_point {

            @BeforeEach
            void setUp() {
                given(Randoms.pickNumberInRange(anyInt(), anyInt()))
                        .willReturn(0)
                        .willReturn(1)
                        .willReturn(2)
                        .willReturn(3);
            }

            @DisplayName("거짓을 반환한다.")
            @Test
            void movableWith3UnderPoint() {
                for (int i = 0; i < 4; i++) {
                    assertThat(moveStrategy.movable()).isFalse();
                }
            }
        }

        @DisplayName("임의의 숫자로 4 이상이 나왔을 경우")
        @Nested
        class Context_with_four_over_point {

            @BeforeEach
            void setUp() {
                given(Randoms.pickNumberInRange(anyInt(), anyInt()))
                        .willReturn(4)
                        .willReturn(5)
                        .willReturn(6)
                        .willReturn(7)
                        .willReturn(8)
                        .willReturn(9);
            }

            @DisplayName("참을 반환한다.")
            @Test
            void movableWith4OverPoint() {
                for (int i = 0; i < 10; i++) {
                    assertThat(moveStrategy.movable()).isTrue();
                }
            }
        }
    }

}
