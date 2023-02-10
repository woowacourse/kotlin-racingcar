package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RacingManagerTest {

    @Test
    fun `게임 초기 세팅이 잘 되는지 확인`() {
        val racingManager = RacingManager(RandomNumberGenerator())
        racingManager.setGame(listOf("test1", "test2", "test3"), 5)
        val cars = racingManager.race()
        assertEquals(3, cars.size)
        assertEquals("test1", cars[0].name)
        assertEquals("test2", cars[1].name)
        assertEquals("test3", cars[2].name)
    }

    @Test
    fun `레이스 게임이 잘 작동하는지 확인`() {
        class TestNumberGenerator : NumberGenerator {
            val list = mutableListOf(1, 4, 9)
            override fun generateNumber(minNumber: Int, maxNumber: Int): Int {
                return list.removeAt(0)
            }
        }

        val racingManager = RacingManager(TestNumberGenerator())
        racingManager.setGame(listOf("test1", "test2", "test3"), 5)
        val cars = racingManager.race()
        assertEquals(3, cars.size)
        assertEquals(0, cars[0].location)
        assertEquals(1, cars[1].location)
        assertEquals(1, cars[2].location)
    }

    @Test
    fun `게임오버가 잘 작동하는지 확인`() {
        val racingManager = RacingManager(RandomNumberGenerator())
        racingManager.setGame(listOf("test1", "test2", "test3"), 1)
        racingManager.race()
        assertEquals(true, racingManager.isOver())
    }
}
