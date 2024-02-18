package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.controller.Race

class RaceTest {
    private val race = Race()

    @DisplayName("시도 횟수가 int 범위를 초과했을 때")
    @Test
    fun exceedIntRangeRoundNumber() {
        val exception =
            assertThrows<IllegalArgumentException> {
                race.checkRoundNumber("35035810684041351035")
            }
        assertEquals(
            ERROR_INPUT_NUMBER_ONLY,
            exception.message,
        )
    }

    @DisplayName("시도 횟수에 숫자가 아닌 다른 문자를 입력 했을 때")
    @ParameterizedTest
    @ValueSource(strings = ["a", "가", "ab", "가나", "?"])
    fun inputLetterForRoundNumber(roundNumber: String) {
        val exception =
            assertThrows<IllegalArgumentException> {
                race.checkRoundNumber(roundNumber)
            }
        assertEquals(
            ERROR_INPUT_NUMBER_ONLY,
            exception.message,
        )
    }

    @DisplayName("시도 횟수를 입력하지 않았을 때")
    @Test
    fun inputEmptyRoundNumber() {
        val exception =
            assertThrows<IllegalArgumentException> {
                race.checkRoundNumber("")
            }
        assertEquals(
            ERROR_INPUT_NUMBER_ONLY,
            exception.message,
        )
    }

    @DisplayName("시도 횟수가 0 이하 일 때")
    @ParameterizedTest
    @ValueSource(strings = ["0", "-1"])
    fun inputLessThanOneRoundNumber(roundNumber: String) {
        val exception =
            assertThrows<IllegalArgumentException> {
                race.getValidRoundNumber(roundNumber)
            }
        assertEquals(
            ERROR_ROUND_LESS_THAN_ONE,
            exception.message,
        )
    }

    companion object {
        const val ERROR_ROUND_LESS_THAN_ONE = "[Error] 1회 이상 입력해 주세요."
        const val ERROR_INPUT_NUMBER_ONLY = "[Error] 숫자만 입력해 주세요."
    }
}
