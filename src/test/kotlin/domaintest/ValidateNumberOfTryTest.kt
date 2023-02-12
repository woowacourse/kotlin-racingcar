package domaintest

import domain.validator.ValidateNumberOfTry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidateNumberOfTryTest {

    lateinit var validateNumberOfTry: ValidateNumberOfTry

    @BeforeEach
    fun setUp() {
        validateNumberOfTry = ValidateNumberOfTry()
    }

    @ParameterizedTest
    @ValueSource(strings = ["30", "10", "5"])
    fun `자연수 형태의 시도 횟수를 입력한 경우`(inputNumberOfTry: String) {
        assertDoesNotThrow {
            validateNumberOfTry(inputNumberOfTry)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "세번", "*"])
    fun `숫자 이외의 것을 입력한 경우`(inputNumberOfTry: String) {
        assertThrows<IllegalArgumentException> {
            validateNumberOfTry(inputNumberOfTry)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-3", "4.5"])
    fun `자연수가 아닌 음수, 실수를 입력한 경우`(inputNumberOfTry: String) {
        assertThrows<IllegalArgumentException> {
            validateNumberOfTry(inputNumberOfTry)
        }
    }
}
