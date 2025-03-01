package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    private val car = Car("a,b,c")

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `4 이상일 때 자동차가 1회 전진한다`(number: Int) {
        car.moves(number)
        val expectedPosition = 1
        val result = car.position

        assertEquals(expectedPosition, result)
    }

    @ValueSource(ints = [1, 2, 3])
    @ParameterizedTest
    fun `4 미만일 때 자동차가 정지한다`(number: Int) {
        car.moves(number)
        val expectedPosition = 0
        val result = car.position

        assertEquals(expectedPosition, result)
    }

    @Test
    fun `자동차가 2회 전진하면 자동차에 저장된 상태는 2이다`() {
        val expectedPosition = 2
        val numbers = listOf(1, 2, 4, 5)
        numbers.forEach { number ->
            car.moves(number)
        }
        val result = car.position
        assertEquals(expectedPosition, result)
    }
}
