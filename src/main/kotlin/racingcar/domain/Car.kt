package racingcar.domain

import racingcar.global.InputValidator.requireCarName

class Car(
    val name: String,
) {
    init {
        requireCarName(name)
    }

    var distance: Int = 0
        private set

    fun moveForward(inputNum: Int) {
        if (inputNum >= 4) {
            distance++
        }
    }
}
