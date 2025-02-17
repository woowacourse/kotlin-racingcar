package domain.numbergenerator

import Constants
import kotlin.random.Random

object RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(Constants.RANDOM_NUMBER_LOWER_BOUND, Constants.RANDOM_NUMBER_UPPER_BOUND)
    }
}
