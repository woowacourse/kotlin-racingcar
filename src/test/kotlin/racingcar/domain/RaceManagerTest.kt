package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import racingcar.racingcar.domain.Cars
import racingcar.racingcar.domain.numbergenerator.NumberGenerator
import racingcar.racingcar.domain.numbergenerator.RandomNumberGenerator
import racingcar.racingcar.domain.raceresult.RacerResult

internal class RaceManagerTest {

    @Test
    fun `게임 결과가 정상적으로 반환된다`() {
        // given
        val raceManager = RaceManager(TestNumberGenerator(mutableListOf(1, 4, 9, 1, 4, 9)))
        val cars = Cars.create(listOf("test1", "test2", "test3"))
        // when
        val raceResult = raceManager.race(cars, 2)
        // then
        assertEquals(raceResult.result[0].racers[0], RacerResult("test1", 0))
        assertEquals(raceResult.result[0].racers[1], RacerResult("test2", 1))
        assertEquals(raceResult.result[0].racers[2], RacerResult("test3", 1))
        assertEquals(raceResult.result[1].racers[0], RacerResult("test1", 0))
        assertEquals(raceResult.result[1].racers[1], RacerResult("test2", 2))
        assertEquals(raceResult.result[1].racers[2], RacerResult("test3", 2))
    }

    @Test
    fun `우승자 정상반환 확인`() {
        // given
        val raceManager = RaceManager(RandomNumberGenerator())
        val cars = Cars(
            listOf(
                Car("test1", 0),
                Car("test2", 2),
                Car("test3", 2),
            ),
        )
        // when
        val winners = raceManager.getWinners(cars)
        // then
        assertEquals(winners, listOf("test2", "test3"))
        assertNotEquals(winners, listOf("test3"))
    }

    class TestNumberGenerator(private val numbers: MutableList<Int>) : NumberGenerator {
        override fun generateNumber(minNumber: Int, maxNumber: Int): Int {
            return numbers.removeAt(0)
        }
    }
}
