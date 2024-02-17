package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.findWinnerNames

class RacingTest {
    @Test
    fun `우승자 한명인 경우 테스트`() {
        val cars = listOf(Car("a", 1), Car("b", 5), Car("c", 3))

        val winner = findWinnerNames(cars)
        val expected = listOf("b")

        assertEquals(expected, winner)
    }

    @Test
    fun `우승자가 여러명인 경우 테스트`() {
        val cars = listOf(Car("a", 1), Car("b", 5), Car("c", 5))

        val winner = findWinnerNames(cars)
        val expected = listOf("b", "c")

        assertEquals(expected, winner)
    }

    @Test
    fun `차가 올바르게 전진한 경우 테스트`() {
        val car = Car(name = "abc")

        car.move(4)
        val expected = 4
        val actual = car.position

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `차가 올바르지 않게 전진한 경우 테스트`() {
        val car = Car(name = "abc")

        car.move(4)
        val expected = 3
        val actual = car.position

        assertThat(actual).isNotEqualTo(expected)
    }
}
