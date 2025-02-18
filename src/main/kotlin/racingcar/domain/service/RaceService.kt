package racingcar.domain.service

import racingcar.domain.model.Car

class RaceService(
    private val _cars: List<Car>,
) {
    val cars get() = _cars.map { car -> car.copy() }

    fun race() {
        _cars.forEach { car -> car.move() }
    }
}
