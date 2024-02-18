package study

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.findWinnerNames
class RacingTest() {
    @Test
    fun `우승자 한명인 경우 테스트`() {
        val cars = listOf(Car("a", 1), Car("b", 5), Car("c", 3))

        val winner = findWinnerNames(cars)
        val expected = listOf("b")

        assertEquals(expected, winner)
    }

    @Test
    fun `우승자가 여러명인 경우 테스트`(){
        val cars = listOf(Car("a", 1), Car("b", 5), Car("c", 5))

        val winner = findWinnerNames(cars)
        val expected = listOf("b","c")

        assertEquals(expected, winner)
    }
}

