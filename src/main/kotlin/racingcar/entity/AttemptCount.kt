package racingcar.entity

data class AttemptCount(val value: Int) {
    init {
        require(value >= MIN_ATTEMPT_COUNT) { "1번 이상 시도해아 합니다." }
    }

    companion object {
        const val MIN_ATTEMPT_COUNT = 1
    }
}
