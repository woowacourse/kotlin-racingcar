package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TryNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun notPositive(value: Int) {
        assertThatIllegalArgumentException().isThrownBy { TryNumber(value) }
    }

    @Test
    fun notParsableToInteger() {
        val string = "hello"

        assertThatIllegalArgumentException().isThrownBy { TryNumber(string) }
    }

    @Test
    fun isGameOver() {
        val tryNumber = TryNumber(1)

        tryNumber.decrease()

        assertThat(tryNumber.isGameOver()).isTrue
    }

    @Test
    fun decrease() {
        // given
        val tryNumber = TryNumber(2)

        // when
        tryNumber.decrease()

        // then
        assertThat(tryNumber).isEqualTo(TryNumber(1))
    }
}
