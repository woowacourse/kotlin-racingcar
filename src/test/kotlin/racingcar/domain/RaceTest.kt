package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RaceTest {
    private val race = Race(listOf(Car("a"), Car("b"), Car("c")))

    @Test
    fun `자동차의 총 전진 횟수가 같을 때 공동 우승한다`() {
        val randomValues = listOf(4, 2, 6, 4, 5, 6, 7, 8, 9)
        val tryCount = 3
        var index = 0
        repeat(tryCount) {
            race.cars.forEach { car ->
                car.moves(randomValues[index])
                index++
            }
        }
        assertEquals(listOf("a", "c"), race.getWinners())
    }
}
