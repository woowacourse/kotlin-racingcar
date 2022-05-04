package racingcar

class GameResult(private val cars: Cars) {

    fun pickWinners(): List<String> {
        val rawCars = cars.cars
        return rawCars.filter { it.isSamePosition(cars.max()) }
            .map { it.name }
    }
}
