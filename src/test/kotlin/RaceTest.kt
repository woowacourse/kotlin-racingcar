import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.Race
import racingcar.util.RandomGenerator

class RaceTest {
    @Test
    fun `원하는 횟수 만큼 경주가 지속된다`() {
        val raceCars = Cars(listOf(Car("1"), Car("2")))
        val raceCount = 5
        val randomGenerator = RandomGenerator()

        val race = Race(raceCars, raceCount, randomGenerator)
        var count = 0

        while (race.isNotEnd()) {
            count++
            race.proceed()
        }

        Assertions.assertTrue(count == raceCount)
    }
}
