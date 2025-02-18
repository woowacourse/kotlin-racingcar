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
        validateRaceCount(count)
        return count
    }

    private fun validateRaceCount(count: Int) {
        require(count >= MIN_RACE_COUNT) { "[ERROR] 자동차 경주는 ${MIN_RACE_COUNT}회 이상 이루어져야 합니다." }
    }

    companion object {
        private const val RACE_CAR_NAME_DIVIDER = ","
        private const val MIN_RACE_COUNT = 1
    }
}
