package racingcar.model

class AttemptCount constructor(attemptCount: Int) {
    init {
        require(attemptCount >= MIN_ATTEMPT_COUNT) { "1번 이상 시도해아 합니다." }
    }

    val indices = IntRange(0, attemptCount - 1)

    companion object {
        const val MIN_ATTEMPT_COUNT = 1
    }
}
