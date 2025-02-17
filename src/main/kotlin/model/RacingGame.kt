package model

import view.OutputView

class RacingGame(
    private val generator: NumberGenerator,
    private val cars: List<Car>,
) {
    fun runRace(rawCount: String) {
        require(rawCount.toIntOrNull()?.let { it > 0 } == true) { INVALID_COUNT_MESSAGE }

        repeatRacing(rawCount.toInt())
    }

    fun getWinners(): List<String> {
        return cars.filter { it.position == cars.maxOf { car -> car.position } }
            .map { it.name }
    }

    private fun repeatRacing(count: Int) {
        repeat(count) {
            raceOneRound()
            OutputView.printRaceState(cars)
        }
    }

    private fun raceOneRound() {
        cars.forEach { it.tryForward(generator.generate()) }
    }

    private companion object {
        const val INVALID_COUNT_MESSAGE = "시도할 횟수는 자연수여야 합니다."
    }
}
