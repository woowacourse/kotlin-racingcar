import model.Car
import model.CarState
import model.NumberGenerator
import model.RaceResult

class RacingGame(
    private val generator: NumberGenerator,
    private val cars: List<Car>,
) {
    fun runRace(count: Int): List<RaceResult> {
        require(count > 0) { INVALID_COUNT_MESSAGE }
        return repeatRacing(count)
    }

    private fun repeatRacing(count: Int): List<RaceResult> {
        val raceResults = mutableListOf<RaceResult>()

        repeat(count) { round ->
            raceOneRound()
            val carStates = cars.map { CarState.from(it) }
            raceResults.add(RaceResult(round + 1, carStates))
        }

        return raceResults
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
            .map { it.name }
    }

    private fun raceOneRound() {
        cars.forEach { it.tryForward(generator.generate()) }
    }

    private companion object {
        const val INVALID_COUNT_MESSAGE = "시도할 횟수는 자연수여야 합니다."
    }
}
