package racingcar.domain

class RacingCar(
    private val name: String,
    private var movingState: Int = 0,
) {
    fun moveForward() {
        movingState += 1
    }
}
