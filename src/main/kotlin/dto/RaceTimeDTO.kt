package dto

class RaceTimeDTO(input: String) {
    private var time: Int

    init {
        time = verifyInteger(input)
        verifyRange()
    }

    fun getRaceTime(): Int {
        return time
    }

    private fun verifyInteger(input: String): Int {
        requireNotNull(input.toIntOrNull()) { ERROR_NOT_INTEGER }
        return input.toInt()
    }

    private fun verifyRange() {
        require(time in 1..10) { ERROR_NOT_IN_RANGE }
    }

    companion object {
        const val ERROR_NOT_INTEGER = "시도 횟수는 숫자여야 합니다."
        const val ERROR_NOT_IN_RANGE = "시도 횟수는 1이상 10 이하여야 합니다."
    }
}
