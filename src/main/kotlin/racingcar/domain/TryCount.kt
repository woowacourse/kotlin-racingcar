package racingcar.domain

import racingcar.utils.MAX_ROUND_COUNT
import racingcar.utils.MIN_ROUND_COUNT

class TryCount(
    val number: Int
) {
    init {
        require(checkBoundary()) { ERROR_MESSAGE_ROUND_COUNT_BOUNDARY }
    }

    private fun checkBoundary(): Boolean = number in MIN_ROUND_COUNT..MAX_ROUND_COUNT

    companion object {
        private const val ERROR_MESSAGE_ROUND_COUNT_BOUNDARY = "시도 횟수는 $MIN_ROUND_COUNT 이상 $MAX_ROUND_COUNT 이하로 부탁이요~"
    }
}
