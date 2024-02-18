package racingcar.model

class ThresholdMovementDecisionMaker : MovementDecisionMaker {
    override fun isMovable(num: Int): Boolean = num > STOP_THRESHOLD

    companion object {
        private const val STOP_THRESHOLD = 3
    }
}
