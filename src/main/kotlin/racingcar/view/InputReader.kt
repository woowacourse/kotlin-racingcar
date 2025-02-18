package racingcar.view

import racingcar.model.Car

class InputReader {
    fun readRaceCars(): List<Car> {
        val carNames = readln().split(RACE_CAR_NAME_DIVIDER)
        validateApplicantCars(carNames)

        return carNames.map { name ->
            Car(name)
        }
    }

    private fun validateApplicantCars(carNames: List<String>) {
        require(carNames.size == carNames.toSet().size) {
            "[ERROR] 자동차 이름은 중복될 수 없습니다. (입력한 이름: ${
                carNames.joinToString(
                    ", "
                )
            })"
        }
        require(carNames.size >= MIN_RACE_CAR_COUNT) { "[ERROR] 자동차가 ${MIN_RACE_CAR_COUNT}대 이상일 경우에만 경기가 시작됩니다. (입력한 참가자 수: ${carNames.size} 대)" }
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
        private const val MIN_RACE_CAR_COUNT = 2
    }
}
