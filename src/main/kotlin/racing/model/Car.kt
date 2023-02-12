package racing.model

import racing.validators.CarNameValidator

class Car(private val name: String) {
    private var position = 0

    init {
        CarNameValidator.validateUserCarNameLength(name)
        CarNameValidator.validateUserCarNameLength(name)
    }

    fun getPosition() = position

    fun getName() = name

    fun move(conditionNumber: Int) {
        if (checkMove(conditionNumber)) position++
    }

    private fun checkMove(randomNumber: Int) = randomNumber >= CAN_MOVE_MINIMUM

    companion object {
        private const val CAN_MOVE_MINIMUM = 4
    }
}
