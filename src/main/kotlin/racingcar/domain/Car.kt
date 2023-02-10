package racingcar.domain

import racingcar.resources.ERROR_INPUT_COUNT
import racingcar.resources.ERROR_NAME_LENGTH_RANGE

class Car(val name: String) {
    var location = 0
        private set

    init {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { ERROR_NAME_LENGTH_RANGE }
    }

    fun move(condition: Int) {
        require(condition in MIN_BOUNDARY..MAX_BOUNDARY) { ERROR_INPUT_COUNT }
        if (condition >= STANDARD_BOUNDARY) {
            this.location++
        }
    }

    companion object {
        private const val MIN_NAME_LENGTH = 1
        private const val MAX_NAME_LENGTH = 5
        const val MIN_BOUNDARY = 0
        const val MAX_BOUNDARY = 9
        private const val STANDARD_BOUNDARY = 4
    }
}
