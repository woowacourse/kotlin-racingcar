package model

class Car(val name: String, private var forwardCount: Int = DEFAULT_FORWARD_COUNT) {
    fun moveForward(isMove: Boolean) {
        if (isMove) {
            forwardCount++
        }
    }

    fun getForwardCount(): Int {
        return forwardCount
    }

    companion object {
        private const val DEFAULT_FORWARD_COUNT = 0
    }
}
