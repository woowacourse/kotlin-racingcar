package racingcar.model

import racingcar.util.ErrorConstants.ERROR

@JvmInline
value class Rounds(val value: Int) {
    init {
        require(value in MIN_ROUNDS..MAX_ROUNDS) { INVALID_RANGE_ERROR }
    }

    companion object {
        private const val INVALID_RANGE_ERROR = "$ERROR 1에서 10 사이의 수를 입력해야 합니다."
        private const val MIN_ROUNDS = 1
        private const val MAX_ROUNDS = 10
    }
}
