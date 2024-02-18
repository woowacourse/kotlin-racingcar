package racingcar.view

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.RaceManager
import racingcar.model.RoundNumber

class InputView {
    fun readCarNames(): List<String> {
        val namesString = readln()
        val names = RaceManager().splitNames(namesString)

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
}
