package racingcar.domain

import racingcar.resources.ERROR_INPUT_COUNT
import racingcar.resources.ERROR_NAME_LENGTH_RANGE

class Car(val name: String) {
    var location = 0
        private set

    init {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { ERROR_NAME_LENGTH_RANGE }
    }

    fun plusLocation(num: Int) {
        require(num in MIN_NUMBER..MAX_NUMBER) { ERROR_INPUT_COUNT }
        if (num >= STANDARD_NUMBER) {
            this.location++
        }
    }

    companion object {
        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5
        const val MIN_NUMBER = 0
        const val MAX_NUMBER = 9
        const val STANDARD_NUMBER = 4
    }
}
