package racingcar.model

class Cars(val cars: List<Car>) {

    fun moveAll(moveStrategy: MoveStrategy): Cars {
        val cars = arrayListOf<Car>()
        for (car in this.cars) {
            cars.add(car.move(moveStrategy))
        }
        return Cars(cars)
    }

    fun findMaxPosition(): Int {
        return cars.maxBy { it.position }!!.position
    }

    fun findCarsBySamePosition(position: Int): List<Car> {
        return cars.filter { it.isSamePosition(position) }
    }
}
