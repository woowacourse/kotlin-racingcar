package domain

import java.util.stream.Collectors

class Cars(carNames: List<String>) {

    val cars: List<Car>

    init {
        if (carNames.size != HashSet(carNames).size) {
            throw IllegalArgumentException("중복된 이름을 입력하면 안됩니다.")
        }

        val cars: MutableList<Car> = ArrayList()
        for (name in carNames) {
            cars.add(Car(name))
        }
        this.cars = cars
    }

    fun race(moveStrategy: MoveStrategy) {
        for (car in cars) {
            car.goOrNot(moveStrategy)
        }
    }

    fun findWinners(): List<Car> {
        val carMaxPosition = cars.stream()
            .max(Car::compareTo)
            .orElseThrow { IllegalArgumentException("Car 리스트가 비어있습니다.") }

        return cars.stream()
            .filter { car -> car.isSamePosition(carMaxPosition) }
            .collect(Collectors.toList())
    }
}