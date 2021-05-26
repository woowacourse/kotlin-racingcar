package racingcar.model

const val DEFAULT_POSITION = 0

class Cars(val cars: List<Car>) {

    fun moveAll(moveStrategy: MoveStrategy): Cars {
        val cars = mutableListOf<Car>()
        for (car in this.cars) {
            cars.add(car.move(moveStrategy))
        }
        return Cars(cars)
    }

    fun findMaxPosition(): Int {
        return cars.map { it.position }
            .max() ?: DEFAULT_POSITION
    }

    fun findCarsBySamePosition(position: Int): List<Car> {
        return cars.filter { it.isSamePosition(position) }
    }
}
