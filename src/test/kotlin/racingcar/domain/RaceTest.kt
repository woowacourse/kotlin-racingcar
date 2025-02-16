package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RaceTest {
    private val race = Race("a,b,c", "3")
    private val cars = race.cars

    @Test
    fun `우승자 리스트 정상 출력 확인`() {
        val randomValues = listOf(4, 2, 6, 4, 5, 6, 7, 8, 9)
        var index = 0
        repeat(race.tryCount) {
            cars.forEach { car ->
                car.moves(randomValues[index])
                index++
            }
        }
        assertEquals(listOf("a", "c"), race.getWinners())
    }
}
