package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RacingManagerTest {

    @Test
    fun `게임 초기 세팅이 잘 되는지 확인`() {
        val racingManager = RacingManager(RandomNumberGenerator())
        racingManager.setGame(listOf("test1", "test2", "test3"), 5)
        racingManager.race()
        val names = racingManager.getCarNames()
        assertEquals(3, names.size)
        assertEquals("test1", names[0])
        assertEquals("test2", names[1])
        assertEquals("test3", names[2])
    }

    @Test
    fun `레이스 게임이 잘 작동하는지 확인`() {
        class TestNumberGenerator : NumberGenerator {
            val list = mutableListOf(1, 4, 9)
            override fun generateNumber(MIN_NUMBER: Int, MAX_NUMBER: Int): Int {
                return list.removeAt(0)
            }
        }

        val racingManager = RacingManager(TestNumberGenerator())
        racingManager.setGame(listOf("test1", "test2", "test3"), 5)
        racingManager.race()
        val locations = racingManager.getCarLocations()
        assertEquals(3, racingManager.getCarNames().size)
        assertEquals(3, locations.size)
        assertEquals(0, locations[0])
        assertEquals(1, locations[1])
        assertEquals(1, locations[2])
    }

    @Test
    fun `게임오버가 잘 작동하는지 확인`() {
        val racingManager = RacingManager(RandomNumberGenerator())
        racingManager.setGame(listOf("test1", "test2", "test3"), 1)
        racingManager.race()
        assertEquals(true, racingManager.isOver())
    }
}
