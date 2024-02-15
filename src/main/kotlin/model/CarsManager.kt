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

    fun getWinners(): List<String> {
        val maxForwardCount = getMaxForwardCount()
        return cars.filter { it.getForwardCount() == maxForwardCount }.map { it.name }
    }

    private fun getMaxForwardCount() = cars.maxOfOrNull { it.getForwardCount() }

    private fun isMove(): Boolean = randomNumber.generate() >= 4
}