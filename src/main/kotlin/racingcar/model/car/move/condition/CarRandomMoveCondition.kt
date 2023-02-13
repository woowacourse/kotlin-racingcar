package racingcar.model.car.move.condition

class CarRandomMoveCondition : CarMoveCondition {
    override fun generate(): Int =
        (START_RANDOM_MOVEMENT_PROBABILITY..END_RANDOM_MOVEMENT_PROBABILITY).random()

    class FakeForSuccess : CarMoveCondition {
        override fun generate(): Int = SUCCESS_NUMBER
    }

    class FakeForFailed : CarMoveCondition {
        override fun generate(): Int = FAIL_NUMBER
    }

    companion object {
        private const val START_RANDOM_MOVEMENT_PROBABILITY = 0
        private const val END_RANDOM_MOVEMENT_PROBABILITY = 9

        private const val FAIL_NUMBER = 0
        private const val SUCCESS_NUMBER = 9
    }
}
