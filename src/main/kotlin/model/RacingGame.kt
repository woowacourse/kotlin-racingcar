package model

import view.OutputView

class RacingGame(
    private val generator: RandomNumberGenerator,
    private val cars: List<Car>,
) {
    fun tryRacing(rawCount: String) {
        require(rawCount.toIntOrNull()?.let { it > 0 } == true) { INVALID_COUNT_MESSAGE }

        repeatRacing(rawCount.toInt())
    }

    fun getWinners(): List<String> {
        return cars.filter { it.position == cars.maxOf { car -> car.position } }
            .map { it.name }
    }

    private fun repeatRacing(count: Int) {
        OutputView.printMessage("실행 결과\n")

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
