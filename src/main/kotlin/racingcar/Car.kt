package racingcar

import racingcar.util.ErrorMessage

class Car private constructor(
    val name: String,
    initialDistance: Int = 0,
) {
    var distance: Int = initialDistance
        private set

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
        const val CAR_NAME_SEPARATOR: String = ","
        const val MAX_CAR_NAME_LENGTH: Int = 5

        /**
         * create List<Car> from string value.
         * @throws IllegalArgumentException when any car name doesn't follow car name rule
         * **/
        fun createCars(value: String): List<Car> {
            val carNames: List<String> = value.split(CAR_NAME_SEPARATOR).map { it.trim() }
            if (carNames.any { carName: String -> carName.length > MAX_CAR_NAME_LENGTH }) {
                throw IllegalArgumentException(ErrorMessage.OVER_MAX_CAR_NAME_LENGTH)
            }
            return carNames.map { carName: String -> Car(carName) }
        }
    }
}
