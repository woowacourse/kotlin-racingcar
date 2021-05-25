package racingcar.domain

class Cars(val cars: List<Car>) {

    constructor(carNum: Int) : this(createList(carNum)) {
        createList(carNum)
    }

    fun race() {
        cars.forEach { it.move() }
    }

    fun status(): List<Pair<String, Int>> {
        return cars.map { car -> Pair(car.name, car.position) }
    }

    fun winners(): List<String> {
        val winningPosition: Int = cars
            .map { it.position }
            .max() ?: 0
        return cars
            .filter { it.isSamePosition(winningPosition) }
            .map { it.name }
    }

    companion object {
        private fun createList(carNum: Int): List<Car> {
            val cars = mutableListOf<Car>()
            for (i in 0 until carNum) {
                cars.add(Car(randomMoveStrategy))
            }
            return cars
        }
    }
}

val randomMoveStrategy: () -> Boolean = fun(): Boolean {
    val randomNumber = Math.random() * 10 + 1
    if (randomNumber >= 4) {
        return true
    }
    return false
}

