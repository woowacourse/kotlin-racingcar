package view.validator

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
        require(count.matches(Regex("\\d{1,3}")) && count.toInt() in MIN_ADVANCE_COUNT_RANGE..MAX_ADVANCE_COUNT_RANGE) {
            ADVANCE_COUNT_ERROR
        }
    }

    private const val MIN_CAR_NAMES_SIZE = 2
    private const val MAX_CAR_NAMES_SIZE = 20
    private const val MIN_ADVANCE_COUNT_RANGE = 1
    private const val MAX_ADVANCE_COUNT_RANGE = 100

    private const val CAR_NAMES_DISTINCT_ERROR = "[ERROR] 자동차 이름 간에 중복이 존재합니다."
    private const val CAR_NAMES_SIZE_ERROR = "[ERROR] 자동차는 최소 2대에서 최대 20대 사이여야 합니다."
    private const val CAR_NAMES_REGEX_ERROR = "[ERROR] 자동차의 이름은 한글 혹은 영어로 공백이 없어야 하며 최소 1글자에서 최대 5글자까지 가능합니다."
    private const val ADVANCE_COUNT_ERROR = "[ERROR] 전진 횟수는 1에서 100 사이의 숫자여야 합니다."
}
