package racingcar.utils

class RacingRuleValidator {

    fun isValidateCarNameLength(name: String): Boolean {
        return name.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH
    }
}
