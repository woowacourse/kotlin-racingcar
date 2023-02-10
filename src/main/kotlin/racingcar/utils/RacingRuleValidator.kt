package racingcar.utils

class RacingRuleValidator {

    fun isValidateCarNameLength(name: String): Boolean {
        return name.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH
    }

    fun isValidateNotDuplicatedCarNames(names: List<String>): Boolean {
        return names.distinct().size == names.size
    }

    fun isValidateRoundCountBoundary(count: Int): Boolean {
        return count in MIN_ROUND_COUNT..MAX_ROUND_COUNT
    }
}
