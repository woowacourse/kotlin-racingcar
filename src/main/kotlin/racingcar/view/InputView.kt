package racingcar.view

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.RoundNumber

class InputView {
    fun readCarNames(): List<String> {
        val namesString = readln()
        val names = namesString.split(COMMA)

        names.forEach { name ->
            Car(name)
        }
        Cars(names)
        return names
    }

    fun readRoundNumber(): String {
        val roundNumber = readln()

        RoundNumber(roundNumber)
        return roundNumber
    }

    companion object {
        private const val COMMA = ","
    }
}
