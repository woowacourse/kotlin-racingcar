import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {

    val validator = Validator()

    @ValueSource(strings = ["", "abcdef"])
    @ParameterizedTest
    fun checkNameTest(input: String) {
        assertThrows<IllegalArgumentException> {
            validator.checkName(input)
        }
    }
}
