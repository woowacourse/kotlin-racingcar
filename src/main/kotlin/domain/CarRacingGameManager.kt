package domain

class CarRacingGameManager(
    val cars: List<Car>,
    private val movingStrategy: MovingStrategy
) {
    fun allCarsTryToMoveForward() =
        cars.forEach { if (movingStrategy.isMovable()) it.move() }
}
