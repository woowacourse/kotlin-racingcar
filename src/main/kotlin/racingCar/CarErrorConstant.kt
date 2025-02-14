package racingCar

object CarErrorConstant {
    const val BLANK_NAME = "[ERROR] 자동차 이름은 공백일 수 없습니다."
    const val OUT_OF_RANGE_NAME = "[ERROR] 자동차 이름은 ${Car.MIN_CAR_NAME_LENGTH}자 이상 ${Car.MAX_CAR_NAME_LENGTH}자 이하여야 합니다."
}
