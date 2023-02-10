package racingcar.domain

import racingcar.resources.ERROR_RACING_COUNT_AT_MOST_ONE

class RacingManager(
    private val numberGenerator: NumberGenerator,
) {
    private var _cars = MutableList(0) { Car("") }
    private var cars: List<Car> = _cars
    private var racingCount = 0

    fun race(): List<Car> {
        require(racingCount > 0) { ERROR_RACING_COUNT_AT_MOST_ONE }
        racingCount--
        cars.forEach { it.plusLocation(numberGenerator.generateNumber(Car.MIN_NUMBER, Car.MAX_NUMBER)) }
        return cars
    }

    fun setGame(carNames: List<String>, racingCount: Int) {
        this.cars = carNames.map { Car(it) }
        this.racingCount = racingCount
    }

    fun isOver(): Boolean = racingCount == 0

    fun getWinner(): List<String> {
        val maxLocation = cars.maxOf { it.location }
        return cars.filter { car -> car.location == maxLocation }
            .map { it.name }
    }
}
