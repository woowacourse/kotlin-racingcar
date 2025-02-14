class InputValidator {
    fun validateApplicantCars(carNames: List<String>) {
        require(carNames.size == carNames.toSet().size) { "[ERROR] 자동차 이름은 중복될 수 없습니다. (입력한 이름: ${carNames.joinToString(", ")})" }
        require(carNames.size >= MIN_RACE_CAR_COUNT) { "[ERROR] 자동차가 ${MIN_RACE_CAR_COUNT}대 이상일 경우에만 경기가 시작됩니다. (입력한 참가자 수: ${carNames.size} 대)" }
    }
    fun validateCarName(carName: String) {
        require(carName.isNotBlank()) { "[ERROR] 자동차 이름은 공백일 수 없습니다. (입력한 이름: $carName)" }
        require(carName.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) {
            "[ERROR] 자동차 이름은 ${MIN_CAR_NAME_LENGTH}자 이상 ${MAX_CAR_NAME_LENGTH}자 이하여야 합니다. (입력한 이름: $carName)"
        }
    }

    fun validateRaceCount(count: Int) {
        require(count >= MIN_RACE_COUNT) { "[ERROR] 자동차 경주는 ${MIN_RACE_COUNT}회 이상 이루어져야 합니다." }
    }

    companion object {
        private const val MIN_CAR_NAME_LENGTH = 1
        private const val MAX_CAR_NAME_LENGTH = 5
        private const val MIN_RACE_CAR_COUNT = 2
        private const val MIN_RACE_COUNT = 1
    }
}
