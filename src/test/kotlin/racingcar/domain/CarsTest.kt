package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

private const val PROCEED_FLAG_NUMBER = 4

class CarsTest {
    @Test
    @DisplayName("중복된 이름이 있을 경우 예외를 발생해야 합니다.")
    fun validateDuplicateCarNames() {
        shouldThrow<IllegalArgumentException> {
            Cars(listOf(Car("a"), Car("a"), Car("b")))
        }
    }

    @Test
    @DisplayName("우승자를 판단합니다.")
    fun findWinners() {
        val carA = Car("a")
        val carB = Car("b")
        val cars = Cars(listOf(carA, carB))

        carA.proceed(PROCEED_FLAG_NUMBER)
        assertThat(cars.findWinners())
            .hasSize(1)
            .contains(carA)
    }

    @Test
    @DisplayName("우승자가 중복일 경우 모두 판단합니다.")
    fun findMultiWinners() {
        val carA = Car("a")
        val carB = Car("b")
        val cars = Cars(listOf(carA, carB))

        carA.proceed(PROCEED_FLAG_NUMBER)
        carB.proceed(PROCEED_FLAG_NUMBER)
        assertThat(cars.findWinners())
            .hasSize(2)
            .contains(carA, carB)
    }
}
