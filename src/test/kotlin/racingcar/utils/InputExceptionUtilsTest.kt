package racingcar.utils

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class InputExceptionUtilsTest {
    @Test
    fun `자동차 이름을 5글자 초과로 설정 - 에러 발생`() {
        val input = "woowahan,tech,course"
        assertThrows<IllegalArgumentException> { InputExceptionUtils.checkCarNames(input) }
    }

    @Test
    fun `자동차 이름을 5글자 이하로 설정 - 정상 작동`() {
        val input = "yenny,eddy,hodu,leo"
        assertDoesNotThrow { InputExceptionUtils.checkCarNames(input) }
    }

    @Test
    fun `시도 횟수로 문자 입력 - 에러 발생`() {
        val input = "one"
        assertThrows<IllegalArgumentException> { InputExceptionUtils.checkRoundCnt(input) }
    }

    @Test
    fun `시도 횟수로 0 이하 값 입력 - 에러 발생`() {
        val input = "-1"
        assertThrows<IllegalArgumentException> { InputExceptionUtils.checkRoundCnt(input) }
    }

    @Test
    fun `시도 횟수로 1 이상 입력 - 정상 작동`() {
        val input = "1"
        assertDoesNotThrow { InputExceptionUtils.checkRoundCnt(input) }
    }
}
