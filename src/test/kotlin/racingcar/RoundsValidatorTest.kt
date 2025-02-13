package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.validator.RoundsValidator
import racingcar.validator.RoundsValidator.Companion.EMPTY_INPUT_ERROR
import racingcar.validator.RoundsValidator.Companion.INVALID_RANGE_ERROR
import racingcar.validator.RoundsValidator.Companion.NOT_NUMERIC_ERROR

class RoundsValidatorTest {
    private lateinit var validator: RoundsValidator

    @BeforeEach
    fun setUp() {
        validator = RoundsValidator()
    }

    @Test
    fun `입력값이 비어있을 때 예외 테스트`() {
        Assertions.assertThatThrownBy {
            validator.validate(" ")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EMPTY_INPUT_ERROR)
    }

    @Test
    fun `시도 횟수 입력값이 음수일 때 예외 테스트`() {
        Assertions.assertThatThrownBy {
            validator.validate("-1")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INVALID_RANGE_ERROR)
    }

    @ParameterizedTest
    @ValueSource(strings = ["가나다, abc, ###, 2147483648"])
    fun `시도 횟수 입력값이 숫자가 아닐 때 테스트`(value: String) {
        Assertions.assertThatThrownBy {
            validator.validate(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(NOT_NUMERIC_ERROR)
    }

    @Test
    fun `시도 횟수가 10회를 초과할 때 테스트`() {
        Assertions.assertThatThrownBy {
            validator.validate("11")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INVALID_RANGE_ERROR)
    }
}
