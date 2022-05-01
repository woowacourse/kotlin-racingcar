package racingcar.domain

import racingcar.validator.validateCarName

private var PROCEED_FLAG_NUMBER = 4

data class Car(val name: String, var position: Int = 0) {

    init {
        validateCarName(name)
    }

    fun proceed(number: Int) {
        if (number >= PROCEED_FLAG_NUMBER) {
            position++
        }
    }
}
