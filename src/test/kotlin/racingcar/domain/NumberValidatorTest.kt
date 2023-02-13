package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.validator.NumberValidator

class NumberValidatorTest {
    @ValueSource(strings = ["", "a", "0d9", "-1"])
    @ParameterizedTest
    fun `숫자가 올바르지 않은 경우 오류 발생`(input: String) {
        assertThat(
            NumberValidator.isNumber(input),
        ).isFalse
    }
}
