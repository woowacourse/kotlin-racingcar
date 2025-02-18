package domain.cars

class Car(val carName: String) {
    private var distance: Int = 0

    fun getDistance(): Int {
        return distance
    }

    fun updateDistance(number: Int) {
        if (isMovable(number)) ++distance
    }

    private fun isMovable(number: Int) = number >= MOVING_STANDARD

    companion object {
        private const val MOVING_STANDARD = 4
    }
}
