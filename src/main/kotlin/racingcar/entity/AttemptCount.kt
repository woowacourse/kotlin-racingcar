package racingcar.entity

class AttemptCount constructor(val value: Int) {
    val indices = IntRange(MIN_ATTEMPT_RANGE, value)

    init {
        require(value >= MIN_ATTEMPT_COUNT) { "1번 이상 시도해아 합니다." }
    }

    companion object {
        const val MIN_ATTEMPT_COUNT = 1
        const val MIN_ATTEMPT_RANGE = 0
    }
}
