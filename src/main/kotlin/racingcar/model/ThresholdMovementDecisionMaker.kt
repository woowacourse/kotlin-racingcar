package racingcar.model

import racingcar.constants.Constants.STOP_THRESHOLD

class ThresholdMovementDecisionMaker : MovementDecisionMaker {
    override fun isMovable(num: Int): Boolean = num > STOP_THRESHOLD
}
