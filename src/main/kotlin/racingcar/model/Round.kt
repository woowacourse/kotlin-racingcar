package racingcar.model

import racingcar.utils.MAX_ROUND_COUNT
import racingcar.utils.MIN_ROUND_COUNT
import racingcar.utils.Validator

class Round(val count: Int) {
    init {
        if (count !in MIN_ROUND_COUNT..MAX_ROUND_COUNT) {
            throw IllegalArgumentException(Validator.ROUND_COUNT_OVER_BOUNDARY_ERROR_MESSAGE)
        }
    }
}
