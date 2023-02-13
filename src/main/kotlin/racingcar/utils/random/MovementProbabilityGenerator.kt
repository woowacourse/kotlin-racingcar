package racingcar.utils.random

class MovementProbabilityGenerator : NumberGenerator {
    override fun generate(): Int =
        (START_RANDOM_MOVEMENT_PROBABILITY..END_RANDOM_MOVEMENT_PROBABILITY).random()

    companion object {
        const val START_RANDOM_MOVEMENT_PROBABILITY = 0
        const val END_RANDOM_MOVEMENT_PROBABILITY = 9
    }
}
