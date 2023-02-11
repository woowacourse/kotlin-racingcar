package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import racingcar.racingcar.domain.CarFactory
import racingcar.racingcar.domain.numbergenerator.NumberGenerator

internal class RaceManagerTest {

    @Test
    fun `게임 결과가 정상적으로 반환된다`() {
        val raceManager = RaceManager(TestNumberGenerator(mutableListOf(1, 4, 9, 1, 4, 9)))
        val carFactory = CarFactory(listOf("test1", "test2", "test3"))
        val raceResult = raceManager.race(carFactory, 2)
        assertEquals(listOf(listOf(0, 1, 1), listOf(0, 2, 2)), raceResult.result)
    }

    @Test
    fun `우승자 정상반환 확인`() {
        val raceManager = RaceManager(TestNumberGenerator(mutableListOf(1, 4, 9, 1, 4, 9)))
        val carFactory = CarFactory(listOf("test1", "test2", "test3"))
        raceManager.race(carFactory, 2)
        assertEquals(raceManager.getWinners(carFactory), listOf("test2", "test3"))
        assertNotEquals(raceManager.getWinners(carFactory), listOf("test3"))
    }

    class TestNumberGenerator(private val numbers: MutableList<Int>) : NumberGenerator {
        override fun generateNumber(minNumber: Int, maxNumber: Int): Int {
            return numbers.removeAt(0)
        }
    }
}
