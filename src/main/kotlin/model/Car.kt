package model

import util.Validator

class Car(private val _name: String, private var _position: Int = 0) {

    val name: String
        get() = _name
    val position: Int
        get() = _position

    init {
        Validator().checkName(_name)
    }

    fun move(condition: Int) {
        if (condition >= MOVING_POINT) _position++
    }

    companion object {
        const val MOVING_POINT = 4
    }
}
