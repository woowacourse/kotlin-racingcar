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

        requireNotNull(roundCount) { NOT_INTEGER_TYPE_ERROR_MESSAGE }

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

    companion object {
        const val CAR_NAME_BOUNDARY_ERROR_MESSAGE = "자동차 이름의 길이는 $MIN_CAR_NAME_LENGTH 이상 $MAX_CAR_NAME_LENGTH 이하로 부탁이요~"
        const val DUPLICATED_CAR_NAME_ERROR_MESSAGE = "자동차 이름 중복 빼주세요~"

        const val NOT_INTEGER_TYPE_ERROR_MESSAGE = "숫자 형태로 부탁이요~"
        const val ROUND_COUNT_BOUNDARY_ERROR_MESSAGE = "라운드 횟수는 $MIN_ROUND_COUNT 이상 $MAX_ROUND_COUNT 이하로 부탁이요~"
    }
}
