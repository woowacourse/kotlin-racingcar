package racingcar.domain

import racingcar.util.ErrorMessage

/**
 * create List<Car> from string value.
 * @throws IllegalArgumentException when any car name doesn't follow car name rule
 * **/
class Car(
    val name: String,
    initialDistance: Int = 0,
) {
    var distance: Int = initialDistance
        private set

    init {
        require(name.length <= MAX_CAR_NAME_LENGTH) { ErrorMessage.OVER_MAX_CAR_NAME_LENGTH }
    }

    fun move(number: Int) {
        if (isMovable(number)) {
            distance += 1
        }
    }

    private fun isMovable(random: Int): Boolean = random >= 4

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + distance
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (name != other.name) return false
        if (distance != other.distance) return false

        return true
    }

    companion object {
        const val MAX_CAR_NAME_LENGTH: Int = 5
    }
}
