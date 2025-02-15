package domain.cars

class Car(val carName: String) {
    private var distance: Int = 0

    fun getDistance(): Int {
        return distance
    }

    fun updateDistanceIfMovable(number: Int) {
        if (isMovable(number)) ++distance
    }

    private fun isMovable(number: Int) = number >= MOVING_STANDARD

    override fun toString(): String {
        return "$carName : ${CAR_POSITION_MARK.repeat(distance)}"
    }

    companion object {
        const val CAR_POSITION_MARK = "-"
        private const val MOVING_STANDARD = 4
    }
}
