package racingCar

const val MIN_RACE_COUNT = 1

enum class RaceCountError(
    val message: String,
) {
    INVALID_TYPE("[ERROR] 자동차 경주 횟수는 숫자로 입력해야 합니다."),
    MIN_VALUE("[ERROR] 자동차 경주는 ${MIN_RACE_COUNT}회 이상 이루어져야 합니다."),
    ;

    companion object {
        fun validate(raceCount: String) {
            require(raceCount.toIntOrNull() != null) { INVALID_TYPE.message }
            require(raceCount.toInt() >= MIN_RACE_COUNT) { MIN_VALUE.message }
        }
    }
}
