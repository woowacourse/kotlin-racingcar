package racingcar.model

data class Car(val name: String, var distance: Int = DEFAULT_DISTANCE) {
    override fun toString() = "$name : ${"-".repeat(distance)}"

    fun move(step: Int) {
        distance += step
    }

    companion object {
        const val DEFAULT_DISTANCE = 0
    }
}
