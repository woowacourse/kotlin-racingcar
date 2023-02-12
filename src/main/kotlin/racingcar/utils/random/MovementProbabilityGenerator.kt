package racingcar.utils.random

class MovementProbabilityGenerator : RandomGenerator {
    override fun generate(): Int =
        (START_RANDOM_MOVEMENT_PROBABILITY..END_RANDOM_MOVEMENT_PROBABILITY).random()

    companion object {
        private const val START_RANDOM_MOVEMENT_PROBABILITY = 1
        private const val END_RANDOM_MOVEMENT_PROBABILITY = 10
    }
}
