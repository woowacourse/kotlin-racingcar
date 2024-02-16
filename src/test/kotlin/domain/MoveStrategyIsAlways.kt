package domain

class MoveStrategyIsAlways(private val boolean: Boolean) : MoveStrategy {
    override fun move(car: Car) {
        if (boolean) {
            car.move()
        }
    }
}
