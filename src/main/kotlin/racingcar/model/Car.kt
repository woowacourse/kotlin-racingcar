package racingcar.model

import racingcar.utils.MAX_CAR_NAME_LENGTH
import racingcar.utils.MIN_CAR_NAME_LENGTH

class Car(val name: String) {
    var position: Int = 0
        private set

    init {
        require(name.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) {
            throw IllegalArgumentException(CAR_NAME_LENGTH_OVER_BOUNDARY_ERROR_MESSAGE)
        }
    }

    fun move() = ++position

    companion object {
        private const val CAR_NAME_LENGTH_OVER_BOUNDARY_ERROR_MESSAGE =
            "자동차 이름 길이의 범위는 $MIN_CAR_NAME_LENGTH 이상 $MAX_CAR_NAME_LENGTH 이하입니다."
    }
}
