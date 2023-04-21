package domain

class TrialCount(val value: Int) {
    companion object {
        private const val MIN_VALUE = 1
    }

    init {
        validateLessThanMinimumValue(value)
    }

    private fun validateLessThanMinimumValue(value: Int) {
        require(value >= MIN_VALUE) { "게임 시도 횟수는 $MIN_VALUE 보다 작을 수 없습니다." }
    }
}
