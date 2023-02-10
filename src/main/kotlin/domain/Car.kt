package domain

class Car(
    val name: String, private val movingStrategy: MovingStrategy
) {
    var advanceCount: Int = 0
        private set

    fun move() {
        if (movingStrategy.isMovable())
            advanceCount++
    }
}
