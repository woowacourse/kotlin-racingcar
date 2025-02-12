class Racecourse(
    private val cars: List<Car>,
    private val round: Int,
) {
    fun startRace() {
        repeat(round) {
            startRound()
            println()
        }
        showWinners()
    }

    private fun startRound() {
        cars.forEach { car: Car -> car.move() }
    }

    private fun showWinners() {
        val maxDistance = cars.maxOf { car: Car -> car.distance }
        val winners: List<Car> = cars.filter { car: Car -> car.distance == maxDistance }
        println("최종 우승자: ${winners.joinToString { car: Car -> car.name }}")
    }
}
