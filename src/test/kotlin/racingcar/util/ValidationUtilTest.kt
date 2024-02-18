package racingcar.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidationUtilTest {
    private val validationUtil = ValidationUtil()

    @Test
    fun `validateCarNames with valid names`() {
        val validNames = "car1,car2,car3"
        assertDoesNotThrow { validationUtil.validateCarNames(validNames) }
    }

    @Test
    fun `validateCarNames with invalid names due to wrong character length`() {
        val invalidNames = "car123456,car2,car3"
        assertThrows<IllegalArgumentException> { validationUtil.validateCarNames(invalidNames) }
    }

    @Test
    fun `validateCarNames with invalid names due to duplication`() {
        val invalidNames = "car1,car1,car3"
        assertThrows<IllegalArgumentException> { validationUtil.validateCarNames(invalidNames) }
    }

    @Test
    fun `validateRoundCounts with valid count`() {
        val validCount = "5"
        assertDoesNotThrow { validationUtil.validateRoundCounts(validCount) }
    }

    @Test
    fun `validateRoundCounts with invalid count`() {
        val invalidCount = "0"
        assertThrows<IllegalArgumentException> { validationUtil.validateRoundCounts(invalidCount) }
    }
}
