package racingcar.domain

import racingcar.validator.CarNameValidator

private var PROCEED_FLAG_NUMBER = 4

data class KCar(val name: String, var position: Int = 0) {

    init {
        CarNameValidator.validate(name)
    }

    fun proceed(number: Int) {
        if (number >= PROCEED_FLAG_NUMBER) {
            position++
        }
    }
}
