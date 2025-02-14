package racingcar.domain

import racingcar.InputValidatorService

class Car(
    val name: String,
    var distance: Int = 0,
) {
    private val inputValidatorService = InputValidatorService()

    fun moveByValue(value: Int) {
        inputValidatorService.possibleMoveValueCheck(value)
        if (value >= 4) distance++
    }

    fun getDistanceInfo() = "$name : ${"-".repeat(distance)}"
}
