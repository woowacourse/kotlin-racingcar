package view

object InputView {

    fun readCarNames(): List<String> {
        while (true) {
            val carNames = readln()
            kotlin.runCatching { validateCarNames(carNames) }
                .onSuccess { return carNames.split(",").map { it.trim() } }
                .onFailure { println(it.message) }
        }
    }

    private fun validateCarNames(inputValue: String) {
        val carNames = inputValue.split(",").map { it.trim() }

        require(carNames.size == carNames.distinct().size) {
            ERROR_MESSAGE_FORMAT.format(CAR_NAMES_DISTINCT_ERROR)
        }
        require(carNames.size in MIN_CAR_NAMES_SIZE..MAX_CAR_NAMES_SIZE) {
            ERROR_MESSAGE_FORMAT.format(CAR_NAMES_SIZE_ERROR)
        }
        require(carNames.all { name -> name.matches(Regex("[a-zA-Z가-힣]{1,5}")) }) {
            ERROR_MESSAGE_FORMAT.format(CAR_NAMES_REGEX_ERROR)
        }
    }

    fun readAdvanceCount(): Int {
        while (true) {
            val count = readln()
            kotlin.runCatching { validateAdvanceCount(count) }
                .onSuccess { return count.toInt() }
                .onFailure { println(it.message) }
        }
    }

    private fun validateAdvanceCount(inputValue: String) {
        require(inputValue.matches(Regex("\\d{1,3}")) && inputValue.toInt() in MIN_ADVANCE_COUNT_RANGE..MAX_ADVANCE_COUNT_RANGE) {
            ERROR_MESSAGE_FORMAT.format(ADVANCE_COUNT_ERROR)
        }
    }
}

private const val ERROR_MESSAGE_FORMAT = "[ERROR] %s"
private const val CAR_NAMES_DISTINCT_ERROR = "자동차 이름 간에 중복이 존재합니다."
private const val CAR_NAMES_SIZE_ERROR = "자동차는 최소 2대에서 최대 20대 사이여야 합니다."
private const val CAR_NAMES_REGEX_ERROR = "자동차의 이름은 한글 혹은 영어로 공백이 없어야 하며 최소 1글자에서 최대 5글자까지 가능합니다."
private const val ADVANCE_COUNT_ERROR = "전진 횟수는 1에서 100 사이의 숫자여야 합니다."

private const val MIN_CAR_NAMES_SIZE = 2
private const val MAX_CAR_NAMES_SIZE = 20
private const val MIN_ADVANCE_COUNT_RANGE = 1
private const val MAX_ADVANCE_COUNT_RANGE = 100
