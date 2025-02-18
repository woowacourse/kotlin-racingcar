package racingcar.model

class Cars {
    private lateinit var cars: List<Car>

    fun generateCars(carInput: List<String>) {
        cars = carInput.map { Car(it) }
    }

    fun playRound(): List<Car> {
        cars.forEach { car ->
            val number = (CONDITION_RANDOM_MIN..CONDITION_RANDOM_MAX).random()
            car.move(number)
        }
        return cars
    }

    fun getWinner(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }

    companion object {
        private const val CONDITION_RANDOM_MIN = 0
        private const val CONDITION_RANDOM_MAX = 9
    }
}
