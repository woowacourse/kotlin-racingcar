package racingcar

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.RoundNumber

class RoundNumberTest {
    @DisplayName("시도 횟수가 int 범위를 초과했을 때")
    @Test
    fun exceedIntRangeRoundNumber() {
        assertThrows<IllegalArgumentException> {
            RoundNumber("3242034920490249024")
        }
    }

    @DisplayName("시도 횟수에 숫자가 아닌 다른 문자를 입력 했을 때")
    @ParameterizedTest
    @ValueSource(strings = ["a", "가", "ab", "가나", "?"])
    fun inputLetterForRoundNumber(number: String) {
        assertThrows<IllegalArgumentException> {
            RoundNumber(number)
        }
    }

    @DisplayName("시도 횟수를 입력하지 않았을 때")
    @Test
    fun inputEmptyRoundNumber() {
        assertThrows<IllegalArgumentException> {
            RoundNumber("")
        }
    }

    @DisplayName("시도 횟수가 0 이하 일 때")
    @ParameterizedTest
    @ValueSource(strings = ["0", "-1"])
    fun inputLessThanOneRoundNumber(number: String) {
        assertThrows<IllegalArgumentException> {
            RoundNumber(number)
        }
    }
}
