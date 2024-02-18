package racingcar.service

import racingcar.constants.GameConstants
import kotlin.random.Random

object RandomGenerator {
    fun generate() = Random.nextInt(GameConstants.MAX_RANDOM_NUMBER + 1)
}
