package model

class Car(val name: String) {
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