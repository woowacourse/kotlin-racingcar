package racingcar.model

import racingcar.validator.Validation

class RoundNumber(val input: String) {
    var roundNumber: Int

    init {
        Validation().roundNumber(input)
        roundNumber = input.toInt()
    }
}