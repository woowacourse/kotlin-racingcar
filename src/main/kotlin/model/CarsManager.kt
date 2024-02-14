package model

class CarsManager(private val randomNumber: RandomNumber) {

    lateinit var cars: List<Car>
        private set

    fun create(carsName: List<String>) {
        cars = carsName.map { Car(it) }
    }

    fun move() {
        cars.forEach { it.moveForward(isMove()) }
    }

    private fun isMove(): Boolean = randomNumber.generate() >= 4
}