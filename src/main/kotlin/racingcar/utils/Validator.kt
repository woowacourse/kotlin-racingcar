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
        val roundCount = input.toIntOrNull()

        requireNotNull(roundCount) { NOT_NUMERIC_ERROR_MESSAGE }

        if (roundCount !in MIN_ROUND_COUNT..MAX_ROUND_COUNT) {
            throw IllegalArgumentException(ROUND_COUNT_OVER_BOUNDARY_ERROR_MESSAGE)
        }

        return roundCount
    }

    fun checkCarNameLength(name: String) {
        if (name.length !in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) {
            throw IllegalArgumentException(CAR_NAME_LENGTH_OVER_BOUNDARY_ERROR_MESSAGE)
        }
    }

    companion object {
        const val CAR_NAME_LENGTH_OVER_BOUNDARY_ERROR_MESSAGE =
            "자동차 이름 길이의 범위는 $MIN_CAR_NAME_LENGTH 이상 $MAX_CAR_NAME_LENGTH 이하입니다."

        const val DUPLICATED_CAR_NAME_ERROR_MESSAGE =
            "중복된 자동차 이름이 존재합니다."

        const val NOT_NUMERIC_ERROR_MESSAGE =
            "라운드 횟수는 숫자 형태로 입력해야 합니다."

        const val ROUND_COUNT_OVER_BOUNDARY_ERROR_MESSAGE =
            "라운드 횟수의 범위는 $MIN_ROUND_COUNT 이상 $MAX_ROUND_COUNT 이하입니다."
    }
}
