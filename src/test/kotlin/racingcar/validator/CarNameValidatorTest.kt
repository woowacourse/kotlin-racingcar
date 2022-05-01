package racingcar.validator

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarNameValidatorTest {
    @Test
    @DisplayName("이름이 5글자 초과일 경우 예외를 발생해야 합니다.")
    fun validateNameLength() {
        shouldThrow<IllegalArgumentException> {
            validateCarName("abcdef")
        }
    }

    @Test
    @DisplayName("이름이 비어있을 경우 예외를 발생해야 합니다.")
    fun validateNameEmpty() {
        shouldThrow<IllegalArgumentException> {
            validateCarName("")
        }
    }

    @Test
    @DisplayName("이름이 공백으로 이루어질 경우 예외를 발생해야 합니다.")
    fun validateNameBlank() {
        shouldThrow<IllegalArgumentException> {
            validateCarName("   ")
        }
    }
}