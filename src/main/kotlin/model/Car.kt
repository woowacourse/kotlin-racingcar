package model

import util.Validation

class Car(val name: String) {

    init {
        Validation.checkNameLength(name)
    }

    var forwardCount = DEFAULT_FORWARD_COUNT
        private set

    fun moveForward(isMove: Boolean) {
        if (isMove) {
            forwardCount++
        }
    }

    companion object {
        private const val DEFAULT_FORWARD_COUNT = 0
    }
}
