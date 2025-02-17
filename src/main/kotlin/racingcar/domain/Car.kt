package racingcar.domain

import racingcar.InputValidator

class Car(
    val name: String,
    private val inputValidator: InputValidator,
) {
    var distance: Int = 0
        private set

    init {
        inputValidator.validCarNameChecker(name)
    }

    fun moveByValue(value: Int) {
        inputValidator.possibleMoveValueCheck(value)
        if (value >= 4) distance++
    }

    override fun toString(): String = "$name : ${"-".repeat(distance)}"
}
