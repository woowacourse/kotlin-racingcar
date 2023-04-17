package racingcar.domain

import racingcar.domain.strategy.NumberGenerator

class Cars(cars: List<Car>) {

    private val cars: List<Car>

    init {
        this.cars = cars
    }

    companion object {

        fun from(carNames: List<String>): Cars {
            return Cars(carNames.map { Car(it) })
        }
    }

    fun moveAll(numberGenerator: NumberGenerator) {
        cars.forEach { it.move(numberGenerator.generate()) }
    }

    fun getWinners(): List<Car> {
        val fastestCar: Car = cars.maxBy { it.getPosition() }
        return cars.filter { it.getPosition() == fastestCar.getPosition() }
    }

    fun getCars(): List<Car> {
        return cars.toMutableList()
    }
}
