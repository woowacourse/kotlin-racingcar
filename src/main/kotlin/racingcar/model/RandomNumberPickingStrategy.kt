package racingcar.model

import racingcar.constants.Constants

class RandomNumberPickingStrategy : PickingStrategy {
    override fun pickNumber(): Int =
        (Constants.MINIMUM_RANDOM_SELECTION_NUM..Constants.MAXIMUM_RANDOM_SELECTION_NUM).random()
}
