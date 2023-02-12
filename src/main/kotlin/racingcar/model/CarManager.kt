package racingcar.model

import racingcar.entity.Car
import racingcar.entity.Name

class CarManager(names: List<Name>) {
    private val cars = mutableListOf<Car>()

    init {
        for (name in names) {
            cars.add(Car(name))
        }
    }

    fun determineWinner(): List<Car> {
        val sortedCars = cars.sortedWith { car, car2 -> if (car.compareTo(car2)) -1 else 1 }
        return sortedCars.filter { it.compareTo(sortedCars[0]) }.reversed()
    }

    fun attempt() {
        for (i in 0 until cars.size) {
            step(i, RandomNumber.generate())
        }
    }

    fun step(index: Int, number: Int) {
        require(number in MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER) { "생성된 임의 숫자는 0에서 9사이어야 합니다." }
        if (number >= WIN_NUMBER) {
            cars[index].forward()
        }
    }

    fun makeAttemptLog(): String {
        return cars.joinToString("\n") { it.toString() + " : " + "-".repeat(it.position.toInt()) }
    }

    companion object {
        const val WIN_NUMBER = 4
        const val MIN_RANDOM_NUMBER = 0
        const val MAX_RANDOM_NUMBER = 9
        const val MIN_CAR_COUNT = 2
    }
}
