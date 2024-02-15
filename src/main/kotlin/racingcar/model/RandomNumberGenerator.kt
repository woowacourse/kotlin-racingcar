package racingcar.model

import racingcar.constants.Constants.MAXIMUM_RANDOM_SELECTION_NUM
import racingcar.constants.Constants.MINIMUM_RANDOM_SELECTION_NUM
import kotlin.random.Random

class RandomNumberGenerator {
    fun getRandomNumber() = Random.nextInt(MINIMUM_RANDOM_SELECTION_NUM, MAXIMUM_RANDOM_SELECTION_NUM)
}
