package racingcar.model

import racingcar.misc.Values

class RandomNumberGenerator() : NumberGenerator {
    override fun generate(): Int = (Values.MIN_RANDOM_NUMBER..Values.MAX_RANDOM_NUMBER).random()
}
