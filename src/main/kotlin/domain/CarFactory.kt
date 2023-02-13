package domain

import domain.numbergenerator.RandomNumberGenerator

class CarFactory(carNames: List<String>) {
    private val driver = Driver(RandomNumberGenerator())
    val cars: List<Car>

    init {
        cars = carNames.map { Car(it, driver) }
    }

    fun moveCars() {
        cars.forEach { it.move() }
    }
}
