package exception

class Validator {
    fun checkCarName(input: String): List<String> {
        val names = input.split(",").map { it.trim() }
        for (name in names) {
            checkCarNameLength(name)
            checkInvalidateCarName(name)
        }
        return names
    }

    private fun checkCarNameLength(name: String) {
        if (name.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException(NAME_LENGTH_ERROR)
        }
    }

    private fun checkInvalidateCarName(name: String) {
        if (name.isEmpty()) {
            throw IllegalArgumentException(INVALID_NAME_ERROR)
        }
    }

    fun checkRoundCount(input: String): Int {
        val num = input.toIntOrNull() ?: throw IllegalArgumentException(NOT_NUMBER_ERROR)
        if (num < 0) throw IllegalArgumentException(NEGATIVE_NUMBER_ERROR)
        return num
    }

    companion object {
        private const val ERROR = "[ERROR]"
        private const val NAME_LENGTH_ERROR = "$ERROR 5자를 초과할 수 없습니다."
        private const val INVALID_NAME_ERROR = "$ERROR 올바른 입력 형식이 아닙니다."
        private const val NOT_NUMBER_ERROR = "$ERROR 숫자가 아닙니다."
        private const val NEGATIVE_NUMBER_ERROR = "$ERROR 시도 횟수는 음수일 수 없습니다."
        private const val MAX_NAME_LENGTH = 5
    }
}
