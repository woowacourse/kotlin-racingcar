package racingcar.utils

class RacingRuleValidator {

    fun isValidateCarNameLength(name: String): Boolean {
        return name.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH
    }

    fun isValidateRoundCountBoundary(count: Int): Boolean {
        return count in MIN_ROUND_COUNT..MAX_ROUND_COUNT
    }
}
