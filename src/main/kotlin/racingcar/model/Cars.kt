package racingcar.model

import kotlin.streams.toList

class Cars(val cars: List<Car>) {

    fun moveAll(moveStrategy: MoveStrategy): Cars {
        val cars = arrayListOf<Car>()
        for (car in this.cars) {
            cars.add(car.move(moveStrategy))
        }
        return Cars(cars)
    }

    fun findMaxPosition(): Int {
        return cars.stream()
            .map { it.position }
            .toList()
            .max()!!
    }

    fun findCarsBySamePosition(position: Int): List<Car> {
        return cars.filter { it.isSamePosition(position) }
            .toList()
    }
}
