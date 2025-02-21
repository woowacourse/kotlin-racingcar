package racingcar.domain

class Car(
    val name: String,
) {
    var distance: Int = 0
        private set

    fun moveForward(inputNum: Int) {
        if (inputNum >= 4) {
            distance++
        }
    }
}
