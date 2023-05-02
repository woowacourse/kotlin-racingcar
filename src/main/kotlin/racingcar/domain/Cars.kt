package racingcar.domain

import racingcar.domain.strategy.NumberGenerator

class Cars(val cars: List<Car>) {

    fun moveAll(numberGenerator: NumberGenerator) {
        cars.forEach { it.move(numberGenerator.generate()) }
    }

    fun getWinners(): List<Car> {
        val fastestPosition: Int = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == fastestPosition }
    }

    companion object {
        fun from(carNames: List<String>): Cars {
            return Cars(carNames.map { Car.from(it) })
        }
    }
}
