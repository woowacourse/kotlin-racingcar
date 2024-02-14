package racingcar.model

data class Car(val name: String, var distance: Int = 0) {

    fun move(step: Int) {
        distance += step
    }
}