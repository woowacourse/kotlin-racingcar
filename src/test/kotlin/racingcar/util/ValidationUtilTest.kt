package racingcar.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidationUtilTest {
    private val validationUtil = ValidationUtil()

    @Test
    fun `유효한 자동차 이름이 입력될 시 예외가 발생하지 않는다`() {
        val validNames = "car1,car2,car3"
        assertDoesNotThrow { validationUtil.validateCarNames(validNames) }
    }

    @Test
    fun `자동차 이름이 5글자가 넘을 경우 에외가 발생한다`() {
        val invalidNames = "car123456,car2,car3"
        assertThrows<IllegalArgumentException> { validationUtil.validateCarNames(invalidNames) }
    }

    @Test
    fun `자동차 이름이 중복될 경우, 에외가 발생한다`() {
        val invalidNames = "car1,car1,car3"
        assertThrows<IllegalArgumentException> { validationUtil.validateCarNames(invalidNames) }
    }

    @Test
    fun `자연수가 라운드의 수로 입력될 시 예외가 발생하지 않는다`() {
        val validCount = "5"
        assertDoesNotThrow { validationUtil.validateRoundCounts(validCount) }
    }

    @Test
    fun `자연수가 아닌 수가 라운드의 수로 입력될 시 예외가 발생한다`() {
        val invalidCount = "0"
        assertThrows<IllegalArgumentException> { validationUtil.validateRoundCounts(invalidCount) }
    }
}
