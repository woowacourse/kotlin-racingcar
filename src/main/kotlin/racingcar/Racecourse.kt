package racingcar

class Racecourse(
    private val cars: List<Car>,
    private val roundManager: RoundManager,
) {
    fun startRace(onEachRound: () -> Unit) {
        roundManager.play(
            onEachRound = {
                moveCars()
                onEachRound()
            },
        )
    }

    private fun moveCars() {
        cars.forEach { car: Car -> car.move((0..9).random()) }
    }

    val winners: List<Car>
        get() {
            val maxDistance = cars.maxOf { car: Car -> car.distance }
            val winners: List<Car> = cars.filter { car: Car -> car.distance == maxDistance }
            return winners
        }
}
