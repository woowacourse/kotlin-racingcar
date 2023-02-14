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
        val raceManager = RaceManager(TestNumberGenerator(mutableListOf(0, 6, 9, 0, 7, 9)), listOf("test1", "test2", "test3"), 2)
        raceManager.race()
        assertEquals(raceManager.getWinner(raceManager.cars), listOf("test2", "test3"))
        assertNotEquals(raceManager.getWinner(raceManager.cars), listOf("test3"))
    }

    @Test
    fun `2라운드를 실행하는 레이스의 경우, 레이스 결과 반환시, 2라운드의 히스토리가 반환되어야한다`() {
        val raceManager = RaceManager(TestNumberGenerator(mutableListOf(1, 4, 3, 5, 4, 2)), listOf("test1", "test2", "test3"), 2)
        val raceResultDto = raceManager.race()
        assertEquals(listOf(listOf(1, 2, 0)), raceResultDto.result)
    }

    class TestNumberGenerator(private val numbers: MutableList<Int>) : NumberGenerator {
        override fun generateNumber(minNumber: Int, maxNumber: Int): Int {
            return numbers.removeAt(0)
        }
    }
}
