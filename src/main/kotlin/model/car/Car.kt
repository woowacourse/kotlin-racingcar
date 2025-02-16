package model.car

import model.number.NumberGenerator

data class Car(val name: String) {
    init {
        require(name.length < CAR_NAME_LENGTH) { CAR_NAME_ERROR }
    }

    private var _position = INIT_POSITION
    val position get() = _position

    fun move(numberGenerator: NumberGenerator) {
        if (numberGenerator.generate() >= MOVE_MIN_NUMBER) _position++
    }

    companion object {
        const val INIT_POSITION = 0
        const val CAR_NAME_LENGTH = 5
        const val MOVE_MIN_NUMBER = 4
        const val CAR_NAME_ERROR = "[ERROR]: 자동차 이름은 5자를 내외입니다."
    }
}
