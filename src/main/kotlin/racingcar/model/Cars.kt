package racingcar.model

class Cars(val cars: List<Car>) : List<Car> by cars {

    fun moveAll(moveStrategy: MoveStrategy): Cars {
        val newCars = map { it.move(moveStrategy) }
        return Cars(newCars)
    }

    fun findMaxPosition(): Int {
        return maxBy { it.position }?.position ?: 0
    }

    fun findCarsBySamePosition(position: Int): List<Car> {
        return filter { it.isSamePosition(position) }
    }
}
