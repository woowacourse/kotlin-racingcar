package racingcar.domain.model

class AttemptCount(private val input: String) {
    init {
        validateAttemptCount()
    }

    fun getCount(): Int = input.toInt()

    private fun validateAttemptCount() {
        require(input.isNotEmpty()) { "시도 횟수를 입력해주세요." }
        require(input.toIntOrNull() != null) { "시도 횟수는 숫자여야 합니다." }
        require(input.toInt() > 0) { "시도 횟수는 1회 이상이어야 합니다." }
    }
}
