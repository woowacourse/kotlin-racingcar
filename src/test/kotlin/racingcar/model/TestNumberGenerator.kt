package racingcar.model

import racingcar.constants.Constants.MAXIMUM_RANDOM_SELECTION_NUM
import racingcar.constants.Constants.MINIMUM_RANDOM_SELECTION_NUM
import racingcar.constants.Constants.STOP_THRESHOLD

class TestNumberGenerator : NumberGenerator {

    private var trial = 0

    override fun getNumber(): Int {
        trial++
        if (trial % DIVISION_NUM != 0) {
            return (MINIMUM_RANDOM_SELECTION_NUM..STOP_THRESHOLD).random()
        }
        return (STOP_THRESHOLD + 1..MAXIMUM_RANDOM_SELECTION_NUM).random()
    }

    companion object {
        private const val DIVISION_NUM = 2
    }
}
