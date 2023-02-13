package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import racingcar.racingcar.domain.Cars
import racingcar.racingcar.domain.numbergenerator.NumberGenerator
import racingcar.racingcar.domain.numbergenerator.RandomNumberGenerator
import racingcar.racingcar.domain.raceresult.RacerResult

internal class RaceManagerTest {
    @Nested
    inner class `게임의 결과 중에서` {
        // given
        private val raceManager = RaceManager(TestNumberGenerator(mutableListOf(1, 4, 9, 1, 4, 9)))
        private val cars = Cars.create(listOf("test1", "test2", "test3"))

        // when
        private val raceResult = raceManager.race(cars, 2)

        @Test
        fun `게임 첫번째 경기가 정상적으로 반환된다`() {
            // then
            raceResult.result[0].run {
                assertEquals(racers[0], RacerResult("test1", 0))
                assertEquals(racers[1], RacerResult("test2", 1))
                assertEquals(racers[2], RacerResult("test3", 1))
            }
        }

        @Test
        fun `게임 두번째 경기가 정상적으로 반환된다`() {
            raceResult.result[1].run {
                assertEquals(racers[0], RacerResult("test1", 0))
                assertEquals(racers[1], RacerResult("test2", 2))
                assertEquals(racers[2], RacerResult("test3", 2))
            }
        }
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
