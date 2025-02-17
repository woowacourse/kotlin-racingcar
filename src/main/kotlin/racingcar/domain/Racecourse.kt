package racingcar.domain

class Racecourse(
    private val cars: List<Car>,
    private val round: Int,
) {
    fun startRace() {
        repeat(round) {
            startRound()
            println()
        }
        println("최종 우승자: ${winners.joinToString { car: Car -> car.name }}")
    }

    private fun startRound() {
        cars.forEach { car: Car ->
            if (isMovable(generateRandomNumber())) {
                car.move()
            }
            displayDistance(car)
        }
    }

    fun displayDistance(car: Car) {
        println("${car.name} : ${Car.DISTANCE_SYMBOL.repeat(car.distance)}")
    }

    private fun generateRandomNumber(): Int = (0..9).random()

    fun isMovable(number: Int): Boolean = number >= MOVEMENT_CONDITION

    val winners: List<Car>
        get() {
            val maxDistance = cars.maxOf { car: Car -> car.distance }
            val winners: List<Car> = cars.filter { car: Car -> car.distance == maxDistance }
            return winners
        }

    companion object {
        const val MOVEMENT_CONDITION: Int = 4
    }
}
