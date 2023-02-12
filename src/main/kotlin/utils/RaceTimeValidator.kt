package utils

class RaceTimeValidator : Validator<Int> {
    override fun validate(input: String): Int {
        val time = verifyInteger(input)
        verifyRange(time)
        return time
    }

    private fun verifyInteger(input: String): Int {
        val time = input.toIntOrNull()
        requireNotNull(time) { "$ERROR_NOT_INTEGER\n잘못된 입력값 : $input" }
        return time
    }

    private fun verifyRange(time: Int) {
        require(time in 1..10) { "$ERROR_NOT_IN_RANGE\n잘못된 입력값 : $time" }
    }

    companion object {
        const val ERROR_NOT_INTEGER = "시도 횟수는 숫자여야 합니다."
        const val ERROR_NOT_IN_RANGE = "시도 횟수는 1이상 10 이하여야 합니다."
    }
}
