package domain

class CarRacingGameManager(
    private val cars: List<Car>,
    private val movingStrategy: MovingStrategy
) {
    fun allCarsTryToMoveForward() =
        cars.forEach { if (movingStrategy.isMovable()) it.move() }

    fun getWinCars(): List<Car> {
        val maxAdvancedCount: Int = cars.maxOf { it.advanceCount }
        return cars.filter { it.advanceCount == maxAdvancedCount }
    }
}
