package racingcar.domain

import racingcar.resources.ERROR_MESSAGE_PREFIX

class RacingManager(
    private val numberGenerator: NumberGenerator,
) {
    private var _cars = MutableList(0) { Car("") }
    private var cars: List<Car> = _cars
    private var racingCount = 0

    fun race(): List<Car> {
        require(racingCount > 0) { ERROR_RACING_COUNT_AT_MOST_ONE }
        racingCount--
        cars.forEach { it.move(numberGenerator.generateNumber(Car.MIN_BOUNDARY, Car.MAX_BOUNDARY)) }
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

    companion object {
        private const val ERROR_RACING_COUNT_AT_MOST_ONE = ERROR_MESSAGE_PREFIX + "경주 횟수는 1 이상이어야 합니다."
    }
}
