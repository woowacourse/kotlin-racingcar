package racingcar.domain

import racingcar.utils.ErrorHandler.validRandomNumber

class GenerateRandomNumber {
    fun randomNumber() = (0..9).random().validRandomNumber()
}
