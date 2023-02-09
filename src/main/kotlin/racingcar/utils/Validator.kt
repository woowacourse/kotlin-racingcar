package racingcar.utils

class Validator {
    fun checkCarNames(names: List<String>): List<String> {
        checkDuplicatedCarNames(names)
        return names
    }

    private fun checkDuplicatedCarNames(names: List<String>) {
        if (names.toSet().size != names.size) {
            throw IllegalArgumentException(DUPLICATED_CAR_NAME_ERROR_MESSAGE)
        }
    }

    fun checkRoundCount(input: String): Int {
        val roundCount = input.toIntOrNull() ?: throw IllegalArgumentException(NOT_INTEGER_TYPE_ERROR_MESSAGE)

        if (roundCount !in MIN_ROUND_COUNT..MAX_ROUND_COUNT) {
            throw IllegalArgumentException(ROUND_COUNT_BOUNDARY_ERROR_MESSAGE)
        }

        return roundCount
    }

    fun checkCarNameLength(name: String) {
        if (name.length !in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) {
            throw IllegalArgumentException(CAR_NAME_BOUNDARY_ERROR_MESSAGE)
        }
    }
}