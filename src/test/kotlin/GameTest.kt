import domain.Car
import domain.Game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GameTest {
    @Test
    fun `자동차 이름에 중복이 있을 경우 예외가 발생한다`() {
        val cars = listOf(Car("A"), Car("B"), Car("C"), Car("A"))
        assertThrows<IllegalArgumentException> { Game(cars, 1) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1])
    fun `경주 횟수가 1보다 작을 경우 예외를 발생한다`(value: Int) {
        val cars = listOf(Car("A"), Car("B"))
        assertThrows<IllegalArgumentException> { Game(cars, value) }
    }

    @Test
    fun `경주에 참가하는 자동차가 2 대 미만일 경우 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val cars = listOf<Car>()
            Game(cars, 1)
        }
        assertThrows<IllegalArgumentException> {
            val cars = listOf(Car("A"))
            Game(cars, 1)
        }
    }

    @Test
    fun `가장 많이 전진한 자동차를 우승자 리스트에 추가한다`() {
        val cars = listOf(Car("A", 1), Car("B", 0))
        val game = Game(cars, 1)
        val winner = game.getWinner()
        assertThat(winner).isEqualTo(listOf(cars[0]))
    }

    @Test
    fun `가장 많이 전진한 자동차가 여러 대일 경우 모두 우승자 리스트에 추가한다`() {
        val cars = listOf(Car("A", 1), Car("B", 1))
        val game = Game(cars, 1)
        val winner = game.getWinner()
        assertThat(winner).isEqualTo(cars)
    }
}
