package racingcar.entity

import racingcar.misc.Values

class AttemptCount constructor(private val attemptCount: Int) {
    init {

        require(attemptCount >= Values.MIN_ATTEMPT_COUNT) { "1번 이상 시도해아 합니다." }
    }

    val indices = IntRange(0, attemptCount)
}
