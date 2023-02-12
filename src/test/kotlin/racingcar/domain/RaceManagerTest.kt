package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

internal class RaceManagerTest {
    @Test
    fun `게임 초기 세팅이 되는지 확인`() {
        val racingManager = RaceManager(RandomNumberGenerator(), listOf("test1", "test2", "test3"), 5)
        val cars = racingManager.race()
        assertEquals(3, cars.names.size)
        assertEquals("test1", cars.names[0])
        assertEquals("test2", cars.names[1])
        assertEquals("test3", cars.names[2])
    }

    @Test
    fun `게임 결과가 정상적으로 반환된다`() {
        val raceManager = RaceManager(TestNumberGenerator(mutableListOf(1, 4, 9, 1, 4, 9)), listOf("test1", "test2", "test3"), 2)
        val raceResult = raceManager.race()
        assertEquals(listOf(listOf(0, 1, 1), listOf(0, 2, 2)), raceResult.result)
    }

    @Test
    fun `우승자 정상반환 확인`() {
        val raceManager = RaceManager(TestNumberGenerator(mutableListOf(1, 4, 9, 1, 4, 9)), listOf("test1", "test2", "test3"), 2)
        assertEquals(raceManager.getWinner(cars), listOf("test2", "test3"))
        assertNotEquals(raceManager.getWinner(cars), listOf("test3"))
    }

    class TestNumberGenerator(private val numbers: MutableList<Int>) : NumberGenerator {
        override fun generateNumber(minNumber: Int, maxNumber: Int): Int {
            return numbers.removeAt(0)
        }
    }

    companion object {
        val cars = listOf(Car("test1"), Car("test2"), Car("test3"))
    }
}
