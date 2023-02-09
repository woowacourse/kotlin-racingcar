package racingcar.model

import racingcar.entity.Car
import racingcar.entity.Name
import racingcar.misc.Util
import racingcar.misc.Values

class CarManager(private val cars: MutableList<Car>) {
    fun init(names: List<Name>) {
        cars.clear()
        for (name in names) {
            cars.add(Car(name))
        }
        require(cars.size >= Values.MIN_CAR_COUNT) { "경주에는 자동차 2대 이상이 필요합니다." }
    }

    fun determineWinner(): List<Car> {
        val sortedCars = cars.sortedWith { car, car2 -> if (car.compareTo(car2)) -1 else 1 }
        return sortedCars.filter { it.compareTo(sortedCars[0]) }.reversed()
    }

    fun attempt(): String {
        for (i in 0 until cars.size) {
            step(i, Util.generateRandom())
        }
        return makeAttemptLog()
    }

    fun makeAttemptLog() = cars.joinToString("\n") { it.toString() }

    fun step(index: Int, number: Int) {
        require(number in Values.MIN_RANDOM_NUMBER..Values.MAX_RANDOM_NUMBER) { "생성된 임의 숫자는 0에서 9사이어야 합니다." }
        if (number >= Values.WIN_NUMBER) {
            cars[index].forward()
        }
    }
}
