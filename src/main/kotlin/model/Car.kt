package model

import util.Validator

class Car(val name: String, position: Int = 0) {

    private var _position: Int = position
    val position: Int get() = _position

    init {
        Validator().checkName(name)
    }

    fun move(condition: Int) {
        if (condition >= MOVING_POINT) _position++
    }

    companion object {
        const val MOVING_POINT = 4
    }
}
