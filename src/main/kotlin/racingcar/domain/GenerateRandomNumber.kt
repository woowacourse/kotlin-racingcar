package racingcar.domain

import racingcar.utils.Constants.MAX_BOUND
import racingcar.utils.Constants.MIN_BOUND
import racingcar.utils.Validate.validRandomNumber

class GenerateRandomNumber {
    fun randomNumber() = (MIN_BOUND..MAX_BOUND).random().validRandomNumber()
}
