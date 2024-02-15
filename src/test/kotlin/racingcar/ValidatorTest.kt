package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    @Test
    fun `올바른 자동차 이름 입력`() {
        val inputCarNames = listOf("pobi", "woni", "jun")
        assertDoesNotThrow { validator.validateCarNames(inputCarNames) }
    }


    @Test
    fun `자동차 이름 입력 예외처리 (자동차 이름에 공백이 없어야 한다)`() {
        val inputCarNames = listOf("pobi", " woni", "jun")
        assertThrows<IllegalArgumentException> { validator.validateCarNames(inputCarNames) }
    }

    @Test
    fun `자동차 이름 입력 예외처리 (자동차 이름은 1~5자 사이만 가능하다)`() {
        val inputCarNames = listOf("pobib", "woni", "jun")
        assertThrows<IllegalArgumentException> { validator.validateCarNames(inputCarNames) }
    }

    @Test
    fun `자동차 이름 입력 예외처리 (자동차 이름을 최소 1대 이상 입력해야 한다)`() {
        val inputCarNames = emptyList<String>()
        assertThrows<IllegalArgumentException> { validator.validateCarNames(inputCarNames) }
    }

    @Test
    fun `자동차 이름 입력 예외처리 (자동차 이름은 중복이 불가능하다)`() {
        val inputCarNames = listOf("pobi,woni,pobi")
        assertThrows<IllegalArgumentException> { validator.validateCarNames(inputCarNames) }
    }

    companion object {
        val validator = Validator()
    }
}
