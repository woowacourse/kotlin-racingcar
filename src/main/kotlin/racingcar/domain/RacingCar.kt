package racingcar.domain

class RacingCar(
    val name: String,
    private var _movingState: Int = 0,
) {
    val movingState: Int
        get() = _movingState

    fun moveForward() {
        _movingState += 1
    }
}
