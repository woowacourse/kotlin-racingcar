package racingcar.utils.random

class MovementProbabilityGenerator : NumberGenerator {
    override fun generate(): Int =
        (START_RANDOM_MOVEMENT_PROBABILITY..END_RANDOM_MOVEMENT_PROBABILITY).random()

    class FakeForSuccess : NumberGenerator {
        override fun generate(): Int = SUCCESS_NUMBER
    }

    class FakeForFailed : NumberGenerator {
        override fun generate(): Int = FAIL_NUMBER
    }

    companion object {
        const val START_RANDOM_MOVEMENT_PROBABILITY = 0
        const val END_RANDOM_MOVEMENT_PROBABILITY = 9

        private const val FAIL_NUMBER = 0
        private const val SUCCESS_NUMBER = 9
    }
}
