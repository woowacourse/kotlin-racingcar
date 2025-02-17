package domain

class Car(
    val name: String,
) {
    var position: Int = INIT_POSITION
        private set

    fun move(randomNum: Int) {
        if (randomNum >= MOVEMENT_THRESHOLD) {
            ++position
        }
    }

    companion object {
        const val INIT_POSITION = 0
        const val MOVEMENT_THRESHOLD = 4
    }
}
