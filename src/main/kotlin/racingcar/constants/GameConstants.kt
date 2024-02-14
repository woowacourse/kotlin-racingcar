package racingcar.constants

object GameConstants {
    const val SPLIT_DELIMITER = ","

    private const val MIN_CAR_NAME_LENGTH = 1
    private const val MAX_CAR_NAME_LENGTH = 5
    val CAR_NAME_RANGE = MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH

    const val CAR_NAME_REGEX = "[a-zA-Z가-힣0-9]+"
}