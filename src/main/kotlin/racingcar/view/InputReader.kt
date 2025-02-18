package racingcar.view

import racingcar.model.Car
import racingcar.model.Cars

class InputReader {
    fun readRaceCars(): Cars {
        val carNames = readln().split(RACE_CAR_NAME_DIVIDER)
        val cars = carNames.map { name -> Car(name) }
        return Cars(cars, carNames)
    }

    fun readRaceCount(): Int {
        val count = readln().toInt()
        return count
    }

    companion object {
        private const val RACE_CAR_NAME_DIVIDER = ","
    }
}
