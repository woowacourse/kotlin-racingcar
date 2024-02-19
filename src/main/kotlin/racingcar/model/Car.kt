package racingcar.model

data class Car(
    val name: String,
) {
    var position: Int = 0
        private set

    fun moveStep() {
        position++
    }
}
