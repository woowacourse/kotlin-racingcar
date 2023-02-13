package validatorTest

import domain.validator.SuccessiveTokenizerValidator
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SuccessiveTokenizerValidatorTest {

    lateinit var successiveTokenizerValidator: SuccessiveTokenizerValidator

    @BeforeEach
    fun setUp() {
        successiveTokenizerValidator = SuccessiveTokenizerValidator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["우기,제임스,스캇,써니", "우기, abc초코,우 아 한"])
    fun `이름과 이름 사이에만 ,를 적절하게 사용한 경우`(inputCarNames: String) {
        assertDoesNotThrow {
            successiveTokenizerValidator.validate(inputCarNames)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [",,우기,,,", "제임스,우기,,"])
    fun `,를 연속으로 입력한 경우`(inputCarNames: String) {
        assertThrows<IllegalArgumentException> {
            successiveTokenizerValidator.validate(inputCarNames)
        }
    }
}
