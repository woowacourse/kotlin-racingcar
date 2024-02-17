package model

import util.NumberGenerator
import kotlin.random.Random

class RandomNumber : NumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(START_RANDOM_RANGE, END_RANDOM_RANGE)
    }

    companion object {
        private const val START_RANDOM_RANGE = 0
        private const val END_RANDOM_RANGE = 10
    }
}
