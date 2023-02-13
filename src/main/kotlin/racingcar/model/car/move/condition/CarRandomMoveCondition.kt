package racingcar.model.car.move.condition

class CarRandomMoveCondition : CarMoveCondition {
    override operator fun invoke(): Int =
        (START_RANDOM_MOVEMENT_PROBABILITY..END_RANDOM_MOVEMENT_PROBABILITY).random()

    class FakeForSuccess : CarMoveCondition {
        override operator fun invoke(): Int = SUCCESS_NUMBER
    }

    class FakeForFailed : CarMoveCondition {
        override operator fun invoke(): Int = FAIL_NUMBER
    }

    companion object {
        private const val START_RANDOM_MOVEMENT_PROBABILITY = 0
        private const val END_RANDOM_MOVEMENT_PROBABILITY = 9

        private const val FAIL_NUMBER = 0
        private const val SUCCESS_NUMBER = 9
    }
}
