package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {
    private val car = Car("a,b,c")

    @Test
    fun `전진 여부 테스트`() {
        car.moves(true)
        val expected = listOf("-")
        val result = car.moveOrStop

        assertEquals(expected, result)
    }

    @Test
    fun `전진 횟수 테스트`() {
        val expected = 1
        car.moveOrStop.add("-")
        car.moveOrStop.add("")
        val result = car.moveCount()

        assertEquals(expected, result)
    }
}
