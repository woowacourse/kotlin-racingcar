package racingCar.view

class InputView {
    fun readRaceCars(): List<String> {
        val carNames = readln().split(RACE_CAR_NAME_DIVIDER).map { it.trim() }
        require(carNames.size == carNames.toSet().size) { CAR_DUPLICATED_NAME_ERROR_MESSAGE }
        require(carNames.size >= MIN_PARTICIPATING_CAR_COUNT) { MIN_PARTICIPATING_ERROR_MESSAGE }
        return carNames
    }

    fun readRaceCount(): Int {
        val raceCount = readln().trim()
        require(raceCount.toIntOrNull() != null) { RACE_COUNT_INVALID_TYPE_ERROR_MESSAGE }
        require(raceCount.toInt() >= MIN_RACE_COUNT) { RACE_COUNT_MIN_VALUE_ERROR_MESSAGE }
        return raceCount.toInt()
    }

    companion object {
        private const val RACE_CAR_NAME_DIVIDER = ","

        private const val MIN_PARTICIPATING_CAR_COUNT = 2
        private const val CAR_DUPLICATED_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다."
        private const val MIN_PARTICIPATING_ERROR_MESSAGE =
            "[ERROR] 자동차가 ${MIN_PARTICIPATING_CAR_COUNT}대 이상일 경우에만 경기가 시작됩니다."

        private const val MIN_RACE_COUNT = 1
        const val RACE_COUNT_INVALID_TYPE_ERROR_MESSAGE = "[ERROR] 자동차 경주 횟수는 숫자로 입력해야 합니다."
        const val RACE_COUNT_MIN_VALUE_ERROR_MESSAGE = "[ERROR] 자동차 경주는 ${MIN_RACE_COUNT}회 이상 이루어져야 합니다."
    }
}
