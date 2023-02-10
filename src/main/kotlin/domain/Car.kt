package domain

class Car(
    val name: String,
) {
    var advanceCount: Int = 0
        private set

    fun move() {
        advanceCount++
    }
}
