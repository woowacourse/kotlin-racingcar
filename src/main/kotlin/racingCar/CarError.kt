package racingCar

const val MIN_CAR_NAME_LENGTH = 1
const val MAX_CAR_NAME_LENGTH = 5
const val MIN_PARTICIPATING_CAR_COUNT = 2

enum class CarError(
    val message: String,
) {
    DUPLICATED_NAME("[ERROR] 자동차 이름은 중복될 수 없습니다."),
    MIN_PARTICIPATING("[ERROR] 자동차가 ${MIN_PARTICIPATING_CAR_COUNT}대 이상일 경우에만 경기가 시작됩니다."),
    BLANK_NAME("[ERROR] 자동차 이름은 공백일 수 없습니다."),
    OUT_OF_RANGE_NAME_LENGTH(
        "[ERROR] 자동차 이름은 ${MIN_CAR_NAME_LENGTH}자 이상 ${MAX_CAR_NAME_LENGTH}자 이하여야 합니다.",
    ),
    ;

    companion object {
        fun validate(carNames: List<String>) {
            require(carNames.size == carNames.toSet().size) { DUPLICATED_NAME.message }
            require(carNames.size >= MIN_PARTICIPATING_CAR_COUNT) { MIN_PARTICIPATING.message }
            carNames.forEach { carName ->
                require(carName.isNotBlank()) { BLANK_NAME.message }
                require(carName.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) { OUT_OF_RANGE_NAME_LENGTH.message }
            }
        }
    }
}
