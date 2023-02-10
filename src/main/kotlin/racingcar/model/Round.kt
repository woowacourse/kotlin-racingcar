package racingcar.model

class Round(val count: Int) {
    init {
        if (count !in MIN_ROUND_COUNT..MAX_ROUND_COUNT) {
            throw IllegalArgumentException(ROUND_COUNT_OVER_BOUNDARY_ERROR_MESSAGE)
        }
    }

    companion object {
        private const val MIN_ROUND_COUNT = 1
        private const val MAX_ROUND_COUNT = Int.MAX_VALUE
        private const val ROUND_COUNT_OVER_BOUNDARY_ERROR_MESSAGE =
            "라운드 횟수의 범위는 $MIN_ROUND_COUNT 이상 $MAX_ROUND_COUNT 이하입니다."
    }
}
