package domain

class Car(
    val name: String,
    var position: Int = INIT_POSITION,
) {
    fun move(randomNum: Int) {
        if (randomNum >= STANDARD_NUMBER) {
            ++position
        }
    }

    companion object {
        const val INIT_POSITION = 0
        const val STANDARD_NUMBER = 4
    }
}
