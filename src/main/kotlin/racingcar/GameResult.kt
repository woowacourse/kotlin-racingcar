package racingcar

class GameResult(private val cars: Cars) {

    fun pickWinners(): List<String> {
        val rawCars = cars.cars
        val max = calculateMaxPosition(rawCars)
        return rawCars.filter { it.isSamePosition(max) }
            .map { it.name }
    }

    private fun calculateMaxPosition(cars: List<Car>) = cars.maxOf { it.position }
}
