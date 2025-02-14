class Car(
    val name: String,
) {
    var position: Int = INITIAL_CAR_POSITION
        private set

    fun moveForward(isMoved: Boolean) {
        if (isMoved) position++
    }

    companion object {
        private const val INITIAL_CAR_POSITION = 0
    }
}
