package racingcar.model

data class Car(
    val name: String,
    val position: Int = 0
) {
    fun getMoveStepResult(): Car = copy(position = position + MOVE_STEP)

    companion object {
        private const val MOVE_STEP = 1
    }
}
