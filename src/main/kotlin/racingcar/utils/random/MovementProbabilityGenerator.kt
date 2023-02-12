package racingcar.utils.random

class MovementProbabilityGenerator : RandomGenerator {
    override fun generate(start: Int, end: Int): Int =
        (start..end).random()
}
