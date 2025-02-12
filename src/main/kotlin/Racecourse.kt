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
        cars.forEach { car: Car -> car.move() }
    }

    val winners: List<Car>
        get() {
            val maxDistance = cars.maxOf { car: Car -> car.distance }
            val winners: List<Car> = cars.filter { car: Car -> car.distance == maxDistance }
            return winners
        }
}
