package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Validator

class ValidatorTest {
    @Test
    fun `올바른 자동차 이름 입력`() {
        val inputCarNames = listOf("pobi", "woni", "jun")
        assertDoesNotThrow { Validator.validateCarNames(inputCarNames) }
    }

    @Test
    fun `자동차 이름 입력 예외처리 (자동차 이름에 공백이 없어야 한다)`() {
        val inputCarNames = listOf("pobi", " woni", "jun")
        assertThrows<IllegalArgumentException> { Validator.validateCarNames(inputCarNames) }
    }

    @Test
    fun `자동차 이름 입력 예외처리 (자동차 이름은 1~5자 사이만 가능하다)`() {
        val inputCarNames = listOf("pobibb", "woni", "jun")
        assertThrows<IllegalArgumentException> { Validator.validateCarNames(inputCarNames) }
    }

    @Test
    fun `자동차 이름 입력 예외처리 (자동차 이름을 최소 1대 이상 입력해야 한다)`() {
        val inputCarNames = emptyList<String>()
        assertThrows<IllegalArgumentException> { Validator.validateCarNames(inputCarNames) }
    }

    @Test
    fun `자동차 이름 입력 예외처리 (자동차 이름은 중복이 불가능하다)`() {
        val inputCarNames = listOf("pobi,woni,pobi")
        assertThrows<IllegalArgumentException> { Validator.validateCarNames(inputCarNames) }
    }

    @Test
    fun `올바른 시도할 횟수 입력 입력)`() {
        val numberOfRound = "5"
        assertDoesNotThrow { Validator.validateNumberOfRound(numberOfRound) }
    }

    @Test
    fun `시도할 횟수 입력 예외처리 (시도할 횟수는 문자나 공백이 없어야한다)`() {
        val firstNumberOfRound = "오"
        val secondNumberOfRound = "5 "
        assertThrows<IllegalArgumentException> { Validator.validateNumberOfRound(firstNumberOfRound) }
        assertThrows<IllegalArgumentException> { Validator.validateNumberOfRound(secondNumberOfRound) }
    }

    @Test
    fun `시도할 횟수 입력 예외처리 (시도할 횟수는 1회 이상의 숫자여야 한다)`() {
        val numberOfRound = "0"
        assertThrows<IllegalArgumentException> { Validator.validateNumberOfRound(numberOfRound) }
    }
}
