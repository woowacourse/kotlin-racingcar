package racingcar.utils

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RoundNumberGeneratorTest {
    @Test
    @DisplayName("라운드가 음수일 경우 예외를 발생헤야 합니다.")
    fun validateRoundByMinus() {
        shouldThrow<IllegalArgumentException> {
            validateRoundNumber("-23")
        }
    }

    @Test
    @DisplayName("라운드가 0일 경우 예외를 발생해야 합니다.")
    fun validateRoundByZero() {
        shouldThrow<IllegalArgumentException> {
            validateRoundNumber("0")
        }
    }

    @Test
    @DisplayName("라운드에 소수가 입력될 경우 예외를 발생해야 합니다.")
    fun validateRoundByPrime() {
        shouldThrow<IllegalArgumentException> {
            validateRoundNumber("1.33")
        }
    }

    @Test
    @DisplayName("라운드에 숫자가 아닌 값이 입력될 경우 예외를 발생해야 합니다.")
    fun validateRoundByNonNumber() {
        shouldThrow<IllegalArgumentException> {
            validateRoundNumber("abc")
        }
    }
}
