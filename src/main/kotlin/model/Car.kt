package model

class Car(val name: String, private var forwardCount: Int) {
    fun moveForward(isMove: Boolean) {
        if (isMove) {
            forwardCount++
        }
    }
}