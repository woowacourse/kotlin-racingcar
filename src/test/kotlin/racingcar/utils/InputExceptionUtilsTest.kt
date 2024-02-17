package racingcar.utils

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputExceptionUtilsTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " ", ",", ",,"])
    fun `자동차 이름을 빈 칸으로 입력했을 경우 - 에러 발생`(input: String) {
        assertThrows<IllegalArgumentException> { InputExceptionUtils.checkCarNames(input) }
    }

    @Test
    fun `시도 횟수로 문자 입력 - 에러 발생`() {
        val input = "one"
        assertThrows<IllegalArgumentException> { InputExceptionUtils.checkRoundCnt(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "-10"])
    fun `시도 횟수로 0 이하 값 입력 - 에러 발생`(input: String) {
        assertThrows<IllegalArgumentException> { InputExceptionUtils.checkRoundCnt(input) }
    }

    @Test
    fun `시도 횟수로 1 이상 입력 - 정상 작동`() {
        val input = "1"
        assertDoesNotThrow { InputExceptionUtils.checkRoundCnt(input) }
    }
}
