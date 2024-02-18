package racingcar.view

import racingcar.model.RoundNumber

class InputView {
    fun readCarNames(): String = readln()

    fun readRoundNumber(): String {
        val roundNumber = readln()

        RoundNumber(roundNumber)
        return roundNumber
    }
}
