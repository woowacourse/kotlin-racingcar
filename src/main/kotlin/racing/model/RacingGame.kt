package racing.model

import racing.util.RandomNumberGenerator

object RacingGame {

    private val _cars: MutableList<Car> = mutableListOf()
    val cars: List<Car>
        get() = _cars


    fun registerCars(carNames: List<String>) {
        _cars.addAll(carNames.map { name: String -> Car(name) })
    }

    fun removeAllCars(){
        _cars.clear()
    }

    fun moveCars() {
        _cars.forEach { car: Car -> car.move(createRandomNumber()) }
    }

    private fun createRandomNumber(): Int {
        val randomNumberGenerator = RandomNumberGenerator()
        return randomNumberGenerator.generate()
    }

    fun getWinnerNames(): List<String> {
        val maxPosition: Int = getMaxPosition()
        return _cars.filter { car: Car -> car.position == maxPosition }.map { car: Car -> car.name }
    }

    private fun getMaxPosition(): Int {
        return _cars.maxOf { car: Car -> car.position }
    }
}
