package racingcar.service

import racingcar.constants.GameConstants
import racingcar.utils.NumberGenerator
import kotlin.random.Random

class RandomGenerator : NumberGenerator {
    override fun generate() =
        Random.nextInt(GameConstants.MAX_RANDOM_NUMBER + 1)
}
