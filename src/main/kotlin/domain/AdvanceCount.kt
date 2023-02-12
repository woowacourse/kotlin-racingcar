package domain

import common.ERROR_MESSAGE_FORMAT

data class AdvanceCount(val value: Int) {

    init {
        require(value in 1..100) { ERROR_MESSAGE_FORMAT.format(ADVANCE_COUNT_ERROR) }
    }
}

private const val ADVANCE_COUNT_ERROR = "전진 횟수는 최소 1회에서 최대 100회 사이여야 합니다."
