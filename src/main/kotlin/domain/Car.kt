package domain

class Car(
    val name: String,
    position: Int = INIT_POSITION,
) {
    var position: Int = position
        private set

    fun move() {
        ++position
    }

    companion object {
        const val INIT_POSITION = 0
    }
}
