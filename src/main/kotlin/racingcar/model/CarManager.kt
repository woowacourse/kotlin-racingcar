package racingcar.model

import racingcar.entity.Car
import racingcar.entity.Name

class CarManager(private val numberGenerator: NumberGenerator, names: List<Name>) {
    val cars: List<Car> = names.map { Car(it) }

    init {
        require(cars.size >= MIN_CAR_COUNT) { "경주에는 자동차 2대 이상이 필요합니다." }
    }

    fun determineWinner(): List<Car> {
        val sortedCars = cars.sortedWith { car, car2 -> if (car.compareByPosition(car2)) -1 else 1 }
        return sortedCars.filter { it.compareByPosition(sortedCars[0]) }.reversed()
    }

    fun attempt() {
        for (idx in cars.indices) {
            cars[idx].forward(numberGenerator.generate())
        }
    }

    companion object {
        const val MIN_CAR_COUNT = 2
    }
}
