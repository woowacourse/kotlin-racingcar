package racingCar.model

class Cars(
    input: String,
    private val numberGenerator: RandomNumberGenerator = RandomNumberGenerator(RANDOM_MAX_VALUE),
) {
    val parsedCars: List<Car> = input.split(",").map { Car(it.trim()) }

    fun playOneRound() {
        parsedCars.forEach { car ->
            car.moveForward(numberGenerator.generate())
        }
    }

    fun getWinner(): List<String> {
        val maxPosition = parsedCars.maxOf { it.position }
        val winners = parsedCars.filter { it.position == maxPosition }.map { it.name }

        return winners
    }

    companion object {
        const val RANDOM_MAX_VALUE: Int = 9
    }
}
