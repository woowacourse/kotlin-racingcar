package racingcar.domain

import racingcar.resources.ERROR_INPUT_COUNT

class Car(val name: String) {
    var location = 0
        private set

    fun plusLocation(num: Int) {
        require(num in MIN_NUMBER..MAX_NUMBER) { ERROR_INPUT_COUNT }
        if (num >= STANDARD_NUMBER) {
            this.location++
        }
    }

    companion object {
        const val MIN_NUMBER = 0
        const val MAX_NUMBER = 9
        const val STANDARD_NUMBER = 4
    }
}
