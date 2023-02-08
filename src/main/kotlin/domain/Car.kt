package domain

class Car(val name: String, private var moveCount: Int) {
    fun move() {
        moveCount++
    }
}
