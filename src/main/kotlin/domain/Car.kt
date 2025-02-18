package domain

import constant.ErrorConstant

class Car(
    val name: String,
    var currentPosition: Int = DEFAULT_POSITION,
) {
    init {
        require(name.length <= MAX_NAME_LENGTH) { ErrorConstant.ERROR_WRONG_NAME_LENGTH }
    }

    fun moveCar() {
        currentPosition += 1
    }

    companion object {
        const val DEFAULT_POSITION: Int = 0
        const val MAX_NAME_LENGTH: Int = 5
    }
}
