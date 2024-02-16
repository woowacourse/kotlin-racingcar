package domain

class MoveStrategyUsingNumber(private val generatedNumber: Int) : MoveStrategy {
    override fun move(car: Car) {
        if (generatedNumber >= MOVE_LOWER_BOUND) {
            car.move()
        }
    }

    companion object {
        private const val MOVE_LOWER_BOUND = 4
    }
}
