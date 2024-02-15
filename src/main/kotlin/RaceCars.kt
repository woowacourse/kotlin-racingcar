data class RaceCars(private val cars: List<RaceCar>) {
    fun findWinners(): List<RaceCar> = with(cars) {
        val winnerCar = maxOf { it }
        val winnerCars = filter { it.compareTo(winnerCar) == 0 }
        return winnerCars
    }

    override fun toString() = StringBuilder()
        .apply { cars.forEach { append("$it\n") } }
        .toString()
}