package racingcar.domain

import racingcar.domain.strategy.NumberGenerator

class Cars(cars: List<Car>) {

    val cars: List<Car>

    init {
        this.cars = cars
    }

    fun moveAll(numberGenerator: NumberGenerator) {
        cars.forEach { it.move(numberGenerator.generate()) }
    }

    fun getWinners(): List<Car> {
        val fastestCar: Car = cars.maxBy { it.position }
        return cars.filter { it.position == fastestCar.position }
    }

    companion object {
        fun from(carNames: List<String>): Cars {
            return Cars(carNames.map { Car(it) })
        }
    }
}
