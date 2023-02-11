package racingcar.racingcar.domain

import racingcar.domain.Car
import racingcar.racingcar.domain.numbergenerator.NumberGenerator

class CarFactory(names: List<String>) {
    var cars = listOf<Car>()
        private set
    private val _result = mutableListOf<List<Int>>()
    val result: List<List<Int>> get() = _result
    val carNames: List<String>
        get() = cars.map { it.name }
    private val carLocations: List<Int>
        get() = cars.map { it.location }
    val maxLocation: Int
        get() = cars.maxOf { it.location }

    init {
        cars = names.map { Car(it) }
    }

    fun moveCars(numberGenerator: NumberGenerator) {
        cars.forEach { car -> car.move(numberGenerator.generateNumber(Car.MIN_BOUNDARY, Car.MAX_BOUNDARY)) }
        _result.add(carLocations)
    }
}
