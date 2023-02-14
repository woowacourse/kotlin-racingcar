package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

internal class RaceManagerTest {
    @Test
    fun `게임 초기 세팅이 되는지 확인`() {
        val racingManager = RaceManager(RandomNumberGenerator(), listOf("test1", "test2", "test3"), 5)
        val cars = racingManager.race()
        assertEquals(3, cars.size)
        assertEquals("test1", cars[0].name)
        assertEquals("test2", cars[1].name)
        assertEquals("test3", cars[2].name)
    }

    @Test
    fun `게임 결과가 정상적으로 반환된다`() {
        val raceManager = RaceManager(TestNumberGenerator(mutableListOf(1, 4, 9, 1, 4, 9)), listOf("test1", "test2", "test3"), 2)
        val raceResult = raceManager.race()
        assertEquals(listOf(0, 2, 2), listOf(raceResult[0].location, raceResult[1].location, raceResult[2].location))
    }

    @Test
    fun `우승자 정상반환 확인`() {
        val raceManager = RaceManager(TestNumberGenerator(mutableListOf(0, 6, 9, 0, 7, 9)), listOf("test1", "test2", "test3"), 2)
        raceManager.race()
        assertEquals(raceManager.getWinner(raceManager.cars), listOf("test2", "test3"))
        assertNotEquals(raceManager.getWinner(raceManager.cars), listOf("test3"))
    }

    class TestNumberGenerator(private val numbers: MutableList<Int>) : NumberGenerator {
        override fun generateNumber(minNumber: Int, maxNumber: Int): Int {
            return numbers.removeAt(0)
        }
    }
}
