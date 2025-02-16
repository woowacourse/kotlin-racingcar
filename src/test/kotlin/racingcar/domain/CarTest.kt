package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {
    private val car = Car("a,b,c")

    @Test
    fun `랜덤 숫자가 4 이상이면 전진한다`() {
        car.moves(5)
        val expected = listOf("-")
        val result = car.position

        assertEquals(expected, result)
    }

    @Test
    fun `자동차에 저장된 전진 횟수를 계산한다`() {
        val expected = 1
        car.position.add("-")
        car.position.add("")
        val result = car.moveCount()

        assertEquals(expected, result)
    }
}
