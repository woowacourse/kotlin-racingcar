package racing.model

import racing.validators.CarNameValidator

class Car(private val name: String) {
    var position = 0
        private set

    init {
        CarNameValidator.validateUserCarNameLength(name)
        CarNameValidator.validateUserCarNameLength(name)
    }

    fun getName() = name

    fun move(conditionNumber: Int) {
        if (checkMove(conditionNumber)) position++
    }

    private fun checkMove(conditionNumber: Int) = conditionNumber >= CAN_MOVE_MINIMUM

    companion object {
        private const val CAN_MOVE_MINIMUM = 4
    }
}
