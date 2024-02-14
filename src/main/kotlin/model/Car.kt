package model

class Car(val name: String, private var forwardCount: Int = 0) {
    fun moveForward(isMove: Boolean) {
        if (isMove) {
            forwardCount++
        }
    }
}