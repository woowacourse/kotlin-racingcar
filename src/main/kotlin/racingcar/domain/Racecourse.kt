package racingcar.domain

class Racecourse(
    private val cars: List<Car>,
    private val round: Int,
) {
    fun startRace() {
        cars.forEach { it.move(generateRandomNumber()) }
    }

    private fun generateRandomNumber(): Int = (0..9).random()

    val winners: List<Car>
        get() {
            val maxDistance = cars.maxOf { car: Car -> car.distance }
            val winners: List<Car> = cars.filter { car: Car -> car.distance == maxDistance }
            return winners
        }
}
