package racingcar.model

data class Car(val name: String, var distance: Int = 0) {

    override fun toString() = "$name : ${"-".repeat(distance)}"

    fun move(step: Int) {
        distance += step
    }
}