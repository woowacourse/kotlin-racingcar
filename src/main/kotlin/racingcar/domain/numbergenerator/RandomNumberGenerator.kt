package racingcar.domain.numbergenerator

import java.util.Random

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int = Random().nextInt(RANDOM_UPPER_INCLUSIVE + 1)

    companion object {
        const val RANDOM_LOWER_INCLUSIVE = 0
        const val RANDOM_UPPER_INCLUSIVE = 9
    }
}
