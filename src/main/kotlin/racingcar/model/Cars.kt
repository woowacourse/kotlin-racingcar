package racingcar.model

class Cars(val cars: List<Car>) {

    fun moveAll(moveStrategy: MoveStrategy): Cars {
        val newCars = cars.map { it.move(moveStrategy) }
        return Cars(newCars)
    }

    fun findMaxPosition(): Int {
        return cars.maxBy { it.position }!!.position
    }

    fun findCarsBySamePosition(position: Int): List<Car> {
        return cars.filter { it.isSamePosition(position) }
    }
}
