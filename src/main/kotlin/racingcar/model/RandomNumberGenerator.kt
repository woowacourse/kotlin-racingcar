package racingcar.model

import racingcar.constants.Constants.MAXIMUM_RANDOM_SELECTION_NUM
import racingcar.constants.Constants.MINIMUM_RANDOM_SELECTION_NUM

class RandomNumberGenerator {
    fun getRandomNumber() = (MINIMUM_RANDOM_SELECTION_NUM..MAXIMUM_RANDOM_SELECTION_NUM).random()
}
