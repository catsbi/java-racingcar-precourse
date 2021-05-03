package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exceptions.InvalidRoundException;
import racingcar.exceptions.NotExistsNextRoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("레이싱 반복 횟수 일급객체 Round 테스트")
class RoundTest {

    @DisplayName("라운드객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    void create_round_test(int inputRound) {
        //when
        Round round = new Round(inputRound);

        //then
        assertThat(round.getTotalRound()).isEqualTo(inputRound);
    }

    @DisplayName("라운드객체생성 실패 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void create_round_exception_test(int inputRound) {
        //when, then
        assertThatThrownBy(() -> {
            new Round(inputRound);
        }).isInstanceOf(InvalidRoundException.class)
                .hasMessage(InvalidRoundException.DEFAULT_MESSAGE);

    }

    @DisplayName("라운드객체 다음라운드 진행 테스트")
    @Test
    void nextRound_test() {
        //given
        Round round = new Round(3);

        //when
        int firstRound = round.nextRound();
        int secondRound = round.nextRound();
        boolean hasNextRound = round.hasNextRound();

        //then
        assertThat(firstRound).isEqualTo(1);
        assertThat(secondRound).isEqualTo(2);
        assertThat(hasNextRound).isTrue();
    }

    @DisplayName("라운드객체 다음라운드 진행 실패 테스트")
    @Test
    void nextRound_exception_test() {
        //given
        Round round = new Round(2);

        //when, then
        assertThatThrownBy(()->{
            round.nextRound();
            round.nextRound();
            round.nextRound();
        }).isInstanceOf(NotExistsNextRoundException.class);
    }

    @DisplayName("라운드 객체 다음라운드 진행 가능여부 확인 테스트")
    @Test
    void hasNextRound_test() {
        //given
        Round round1 = new Round(2);
        Round round2 = new Round(2);

        //when
        round1.nextRound();
        round2.nextRound();
        round2.nextRound();

        //then
        assertThat(round1.hasNextRound()).isTrue();
        assertThat(round2.hasNextRound()).isFalse();
    }
}
