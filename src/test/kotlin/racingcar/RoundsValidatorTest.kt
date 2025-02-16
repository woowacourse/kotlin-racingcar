package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.validator.RoundsValidator

class RoundsValidatorTest {
    @Test
    fun `시도 횟수 입력값이 음수일 때 예외가 발생한다`() {
        Assertions.assertThatThrownBy {
            RoundsValidator.validate("-1")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(RoundsValidator.INVALID_RANGE_ERROR)
    }

    @ParameterizedTest
    @ValueSource(strings = ["가나다, abc, ###, 2147483648"])
    fun `시도 횟수 입력값이 숫자가 아닐 때 예외가 발생한다`(value: String) {
        Assertions.assertThatThrownBy {
            RoundsValidator.validate(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(RoundsValidator.NOT_NUMERIC_ERROR)
    }

    @Test
    fun `시도 횟수가 10회를 초과할 때 예외가 발생한다`() {
        Assertions.assertThatThrownBy {
            RoundsValidator.validate("11")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(RoundsValidator.INVALID_RANGE_ERROR)
    }
}
