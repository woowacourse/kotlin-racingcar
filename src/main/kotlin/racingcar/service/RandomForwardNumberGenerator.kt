package racingcar.service

import racingcar.constants.GameConstants
import kotlin.random.Random

object RandomForwardNumberGenerator : ForwardNumberGenerator {
    override fun generate() = Random.nextInt(GameConstants.MAX_RANDOM_NUMBER + 1)
}
