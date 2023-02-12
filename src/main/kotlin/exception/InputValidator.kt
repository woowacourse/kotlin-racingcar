package exception

class InputValidator {

    fun checkRoundCount(input: String): Int {
        val num = input.toIntOrNull() ?: throw IllegalArgumentException(NOT_NUMBER_ERROR)
        if (num < 0) throw IllegalArgumentException(NEGATIVE_NUMBER_ERROR)
        return num
    }

    companion object {
        private const val ERROR = "[ERROR]"
        private const val NOT_NUMBER_ERROR = "$ERROR 숫자가 아닙니다."
        private const val NEGATIVE_NUMBER_ERROR = "$ERROR 시도 횟수는 음수일 수 없습니다."
    }
}
