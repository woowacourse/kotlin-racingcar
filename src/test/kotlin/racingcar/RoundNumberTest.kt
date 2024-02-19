package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.RoundNumber

class RoundNumberTest {
    @Test
    fun exceedIntRangeRoundNumber() {
        val exception =
            assertThrows<IllegalArgumentException> {
                RoundNumber("35035810684041351035")
            }

        Assertions.assertThat(exception.message.equals(ERROR_INPUT_NUMBER_ONLY))
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "가", "ab", "가나", "?"])
    fun inputLetterForRoundNumber(roundNumber: String) {
        val exception =
            assertThrows<IllegalArgumentException> {
                RoundNumber(roundNumber)
            }

        Assertions.assertThat(exception.message.equals(ERROR_INPUT_NUMBER_ONLY))
    }

    @Test
    fun inputEmptyRoundNumber() {
        val exception =
            assertThrows<IllegalArgumentException> {
                RoundNumber("")
            }

        Assertions.assertThat(exception.message.equals(ERROR_INPUT_NUMBER_ONLY))
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "-918275817"])
    fun inputLessThanOneRoundNumber(roundNumber: String) {
        val exception =
            assertThrows<IllegalArgumentException> {
                RoundNumber(roundNumber)
            }

        Assertions.assertThat(exception.message.equals(ERROR_ROUND_LESS_THAN_ONE))
    }

    companion object {
        private const val ERROR_ROUND_LESS_THAN_ONE = "[Error] 1회 이상 입력해 주세요."
        private const val ERROR_INPUT_NUMBER_ONLY = "[Error] 숫자만 입력해 주세요."
    }
}