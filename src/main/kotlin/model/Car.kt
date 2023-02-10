package model

import util.Validator

class Car(private val name: String, private var position: Int = 0) {

    init {
        Validator().checkName(name)
    }

    fun getInfo(): CarInfo {
        return CarInfo(name, position)
    }

    fun move(condition: Int) {
        if (condition >= MOVING_POINT) position++
    }

    companion object {
        const val MOVING_POINT = 4
    }
}
