package racingcar.model

class MovementDecisionMaker {
    fun isMoveAble(num: Int): Boolean = num > STOP_THRESHOLD

    companion object {
        private const val STOP_THRESHOLD = 3
    }
}
