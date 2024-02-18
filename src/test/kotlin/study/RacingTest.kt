package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Racing

class RacingTest {
    @Test
    fun `우승자 한명인 경우 테스트`() {
        val racing = Racing()
        val cars = listOf(Car("a"), Car("b"), Car("c"))

        cars[0].move(1)
        cars[1].move(5)
        cars[2].move(3)

        val winner = racing.findWinnerNames(cars)
        val expected = listOf("b")

        assertEquals(expected, winner)
    }

    @Test
    fun `우승자가 여러명인 경우 테스트`() {
        val racing = Racing()
        val cars = listOf(Car("a"), Car("b"), Car("c"))

        cars[0].move(1)
        cars[1].move(5)
        cars[2].move(5)

        val winner = racing.findWinnerNames(cars)
        val expected = listOf("b", "c")

        assertEquals(expected, winner)
    }

    @Test
    fun `차가 올바르게 이동한 경우 테스트`() {
        val car = Car(name = "abc")
        val racing = Racing()

        car.move(4)
        car.move(racing.goOrStop(6))
        val expected = 5
        val actual = car.position

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `차가 올바르게 멈춘 경우 테스트`() {
        val car = Car(name = "abc")
        val racing = Racing()

        car.move(2)
        car.move(racing.goOrStop(3))
        val expected = 2
        val actual = car.position

        assertThat(actual).isEqualTo(expected)
    }
}
