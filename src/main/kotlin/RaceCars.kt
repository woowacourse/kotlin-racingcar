data class RaceCars(private val cars: List<RaceCar>) {
    fun findWinners(): List<RaceCar> {
        with(cars) {
            val winnerCar = maxOf { it }
            val winnerCars = filter { it.compareTo(winnerCar) == 0 }
            return winnerCars
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        cars.forEach {
            sb.append("$it\n")
        }
        return sb.toString()
    }
}