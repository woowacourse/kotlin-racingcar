package racingcar.model.car.move.condition

class CarRandomMoveCondition : CarMoveCondition {
    override operator fun invoke(): Int =
        (START_RANDOM_MOVEMENT_PROBABILITY..END_RANDOM_MOVEMENT_PROBABILITY).random()

    companion object {
        private const val START_RANDOM_MOVEMENT_PROBABILITY = 0
        private const val END_RANDOM_MOVEMENT_PROBABILITY = 9
    }
}
