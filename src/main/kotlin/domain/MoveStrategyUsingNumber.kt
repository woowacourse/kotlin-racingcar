package domain

class MoveStrategyUsingNumber(private val numberGenerator: NumberGenerator) : MoveStrategy {
    override fun move(car: Car) {
        if (numberGenerator.generate() >= MOVE_LOWER_BOUND) {
            car.move()
        }
    }

    companion object {
        private const val MOVE_LOWER_BOUND = 4
    }
}
