package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RaceTest {
    private val race = Race("a,b,c", "3")
    private val cars = race.cars

    @Test
    fun `우승자리스트 테스트`() {
        val randomValues = listOf(4, 2, 6, 4, 5, 6, 7, 8, 9)
        var index = 0
        repeat(race.tryCount) {
            cars.forEach { car ->
                car.moves(randomValues[index] > 3)
                index++
            }
        }
        assertEquals(listOf("a", "c"), race.getWinners())
    }
}
