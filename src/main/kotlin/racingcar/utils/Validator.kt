package racingcar.utils

class Validator {

    fun checkCarNames(input: String): List<String> {
        val names = input.split(CAR_NAME_DELIMITER).toMutableList()

        for (i in names.indices) {
            names[i] = names[i].trim()
            checkCarNameLength(names[i])
        }

        if (names.toSet().size != names.size) {
            throw IllegalArgumentException(DUPLICATED_CAR_NAME_ERROR_MESSAGE)
        }

        return names
    }

    fun checkRoundCount(input: String): Int {
        val roundCount = input.toIntOrNull() ?: throw IllegalArgumentException(NOT_INTEGER_TYPE_ERROR_MESSAGE)

        if (roundCount < MIN_ROUND_COUNT) {
            throw IllegalArgumentException(ROUND_COUNT_BOUNDARY_ERROR_MESSAGE)
        }
        if (roundCount > MAX_ROUND_COUNT) {
            throw IllegalArgumentException(ROUND_COUNT_BOUNDARY_ERROR_MESSAGE)
        }

        return roundCount
    }

    private fun checkCarNameLength(name: String) {
        if (name.length !in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) {
            throw IllegalArgumentException(CAR_NAME_BOUNDARY_ERROR_MESSAGE)
        }
    }
}