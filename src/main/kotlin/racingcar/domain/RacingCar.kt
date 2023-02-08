package racingcar.domain

class RacingCar(
    private val name: String,
    private var movingState: Int = 0,
) : Comparable<RacingCar> {
    fun moveForward() {
        movingState += 1
    }

    override fun compareTo(other: RacingCar): Int {
        return if (this.movingState >= other.movingState) 1 else -1
    }
}
