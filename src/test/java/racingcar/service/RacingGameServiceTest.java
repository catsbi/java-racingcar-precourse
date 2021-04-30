package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.config.TestRacingConfig;
import racingcar.domain.GameHistories;
import racingcar.dto.Winners;
import racingcar.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 경주 비즈니스 로직 테스트")
class RacingGameServiceTest {
    private RacingGameService racingGameService;
    private MoveStrategy moveStrategy;

    @BeforeEach
    void setup() {
        TestRacingConfig config = new TestRacingConfig();

        racingGameService = config.racingGameService();
        moveStrategy = config.moveStrategy();
    }

    @DisplayName("입력받은 횟수만큼 모든 자동차를 전진(혹은 정지) 하도록 해야한다.")
    @ParameterizedTest
    @MethodSource("provideNamesAndRound")
    void game_start_test(List<String> inputNames, int roundCount) {
        //given

        //when
        GameHistories histories = racingGameService.playGame(inputNames, roundCount);

        //then
        Winners winners = histories.getWinners();
        assertThat(winners.getNames()).hasSize(3);
//        assertThat(winners.getNames()).contains("crong", "pobi", "bbo");

    }

    private static Stream<Arguments> provideNamesAndRound() {
        return Stream.of(
                Arguments.of(Arrays.asList("crong", "pobi", "bbo"), 4),
                Arguments.of(Arrays.asList("crong", "pobi", "bbo"), 5),
                Arguments.of(Arrays.asList("crong", "pobi", "bbo"), 6)
        );
    }
}
