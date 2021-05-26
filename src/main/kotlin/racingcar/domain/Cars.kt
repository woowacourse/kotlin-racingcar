package racingcar.domain

class Cars(private val cars: MutableList<Car> = mutableListOf()) {

    constructor(carNum: Int) : this() {
        createList(carNum)
    }

    private fun createList(carNum: Int) {
        repeat(carNum) { cars.add(Car()) }
    }

    fun cars(): List<Car> {
        return cars
    }

    fun race() {
        cars.forEach { car -> car.move() }
    }

    fun status(): Map<String, Int> {
        return cars.associate { it.name to it.position }
    }

    fun winners(): List<String> {
        val winningPosition: Int = cars.maxBy { it.position }?.position ?: 0
        return cars.filter { car -> car.isSamePosition(winningPosition) }
            .map { car -> car.name }
    }
}
