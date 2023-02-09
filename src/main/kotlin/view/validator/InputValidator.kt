package view.validator

import common.ADVANCE_COUNT_ERROR
import common.CAR_NAMES_DISTINCT_ERROR
import common.CAR_NAMES_REGEX_ERROR
import common.CAR_NAMES_SIZE_ERROR

object InputValidator {
    fun validateCarNames(names: String) {
        val carNames = names.split(",").map { it.trim() }
        require(carNames.size == carNames.distinct().size) {
            CAR_NAMES_DISTINCT_ERROR
        }
        require(carNames.size in MIN_CAR_NAMES_SIZE..MAX_CAR_NAMES_SIZE) {
            CAR_NAMES_SIZE_ERROR
        }
        require(carNames.all { name -> name.matches(Regex("[a-zA-Z가-힣]{1,5}")) }) {
            CAR_NAMES_REGEX_ERROR
        }
    }

    fun validateAdvanceCount(count: String) {
        require(count.isAllDigit() && count.length in 1..3 && count.toInt() in MIN_ADVANCE_COUNT_RANGE..MAX_ADVANCE_COUNT_RANGE) {
            ADVANCE_COUNT_ERROR
        }
    }

    private fun String.isAllDigit(): Boolean = this.all { it.isDigit() }

    const val MIN_CAR_NAMES_SIZE = 2
    const val MAX_CAR_NAMES_SIZE = 20
    const val MIN_ADVANCE_COUNT_RANGE = 1
    const val MAX_ADVANCE_COUNT_RANGE = 100
}
