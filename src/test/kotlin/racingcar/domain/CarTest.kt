package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

private const val PROCEED_FLAG_NUMBER = 4

class CarTest {

    @Test
    @DisplayName("이름이 5글자 초과일 경우 예외를 발생해야 합니다.")
    fun validateNameLength() {
        shouldThrow<IllegalArgumentException> {
            Car("abcdef")
        }
    }

    @Test
    @DisplayName("이름이 비어있을 경우 예외를 발생해야 합니다.")
    fun validateNameEmpty() {
        shouldThrow<IllegalArgumentException> {
            Car("")
        }
    }

    @Test
    @DisplayName("이름이 공백으로 이루어질 경우 예외를 발생해야 합니다.")
    fun validateNameBlank() {
        shouldThrow<IllegalArgumentException> {
            Car("   ")
        }
    }

    @Test
    @DisplayName("4 이상의 숫자를 넣으면 전진해야 합니다.")
    fun proceed() {
        val car = Car("k")
        car.proceed(PROCEED_FLAG_NUMBER)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    @DisplayName("4 미만의 숫자를 넣으면 전진을 하지 않아야 합니다.")
    fun not_proceed() {
        val car = Car("k")
        car.proceed(PROCEED_FLAG_NUMBER - 1)
        assertThat(car.position).isEqualTo(0)
    }
}