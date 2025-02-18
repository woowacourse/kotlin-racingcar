package model

class RacingGame(
    private val generator: NumberGenerator,
    private val cars: List<Car>,
) {
    fun runRace(count: Int) {
        require(count > 0) { INVALID_COUNT_MESSAGE }

        repeatRacing(count)
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
            .map { it.name }
    }

    fun repeatRacing(count: Int): List<List<Car>> {
        val raceStates = mutableListOf<List<Car>>()

        repeat(count) {
            raceOneRound()
            raceStates.add(cars.map { it.copy() })
        }

        return raceStates
    }

    private fun raceOneRound() {
        cars.forEach { it.tryForward(generator.generate()) }
    }

    private companion object {
        const val INVALID_COUNT_MESSAGE = "시도할 횟수는 자연수여야 합니다."
    }
}
