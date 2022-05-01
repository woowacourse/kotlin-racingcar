package racingCar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class NameTest{

    @Test
    @DisplayName("빈 값이 들어갈 수 없다")
    fun notEmpty() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Name("") }
    }

    @Test
    @DisplayName("6자리 이상 들어갈 수 없다")
    fun overSize() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Name("pepper") }
    }
}