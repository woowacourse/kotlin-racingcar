package domain

class CarRacingGameManager(
    private val cars: List<Car>
) {
    fun allCarsTryToMoveForward() =
        cars.forEach { it.move() }

    fun getWinCars(): List<Car> {
        val maxAdvancedCount: Int = cars.maxOf { it.advanceCount }
        return cars.filter { it.advanceCount == maxAdvancedCount }
    }
}
