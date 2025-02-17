package racingCar.model

data class Car(
    val name: String,
    private var position: Int = INIT_POSITION,
) {
    fun getPosition() = position

    fun moveForward() = position++

    companion object {
        const val INIT_POSITION = 0
    }
}
