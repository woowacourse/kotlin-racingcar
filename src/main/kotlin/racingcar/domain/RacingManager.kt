package racingcar.domain

import racingcar.resources.ERROR_RACING_COUNT_AT_MOST_ONE

class RacingManager(
    private val numberGenerator: NumberGenerator,
) {
    private lateinit var cars: List<Car>
    private var racingCount = 0

    fun race() {
        require(racingCount > 0) { ERROR_RACING_COUNT_AT_MOST_ONE }
        racingCount--
        cars.forEach { it.plusLocation(numberGenerator.generateNumber(Car.MIN_NUMBER, Car.MAX_NUMBER)) }
    }

    fun getCarNames(): List<String> {
        return cars.map { it.name }
    }

    fun getCarLocations(): List<Int> {
        return cars.map { it.location }
    }

    fun setGame(carNames: List<String>, racingCount: Int) {
        this.cars = carNames.map { Car(it) }
        this.racingCount = racingCount
    }

    fun checkGameIsOver(): Boolean {
        return racingCount == 0
    }

    fun getWinner(): List<String> {
        return cars
            .filter { car -> car.location == cars.maxBy { it.location }.location }
            .map { it.name }
    }
}
