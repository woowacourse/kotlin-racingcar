package racingcar.domain

class RacingCar(
    val name: String,
    movingState: Int = 0,
) {
    var movingState = movingState
        private set

    fun moveForward() {
        movingState += 1
    }
}
