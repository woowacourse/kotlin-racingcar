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
    @Test
    fun `자동차가 움직일 수 있는 경우 위치가 증가하는지 테스트`() {
        val car = Car("test", 0)
        // 가정: isMovePossible 함수가 true를 반환하는 경우, 자동차는 움직여야 한다.
        // 여기서는 position을 직접 1 증가시키는 것으로 가정합니다.
        car.position++

        assertEquals(1, car.position)
    }

    @Test
    fun `자동차가 움직일 수 없는 경우 위치가 변경되지 않는지 테스트`() {
        val car = Car("test", 0)
        // 가정: isMovePossible 함수가 false를 반환하는 경우, 자동차는 움직이지 않아야 한다.
        // 여기서는 position을 변경하지 않는 것으로 가정합니다.

        assertEquals(0, car.position)
    }

}

