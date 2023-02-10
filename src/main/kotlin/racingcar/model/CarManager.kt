package racingcar.model

import racingcar.entity.Car

class CarManager(private val numberGenerator: NumberGenerator, val cars: List<Car>) {
    init {
        require(cars.size >= MIN_CAR_COUNT) { "경주에는 자동차 2대 이상이 필요합니다." }
    }

    fun sortCarByPosition() = cars.sortedWith { car, car2 -> if (car.compareByPosition(car2)) -1 else 1 }

    fun attempt(): List<Car> {
        cars.forEach {
            it.forward(numberGenerator.generate())
        }
        return cars.map { it.copy() }
    }

    companion object {
        const val MIN_CAR_COUNT = 2
    }
}
