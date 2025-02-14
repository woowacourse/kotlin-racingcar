package racingcar

import racingcar.extension.times

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
        displayDistance()
    }

    private fun displayDistance() {
        println("$name : ${"-" * (distance)}")
    }

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
        const val ERROR_MESSAGE_OVER_MAX_CAR_NAME_LENGTH: String = "자동차 이름은 5자를 초과할 수 없습니다. 다시 입력해주세요."

        fun isMovable(random: Int): Boolean {
            // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
            return random >= 4
        }

        /**
         * create List<Car> from string value.
         * @throws IllegalArgumentException when any car name doesn't follow car name rule
         * **/
        fun createCars(value: String): List<Car> {
            val carNames: List<String> = value.split(CAR_NAME_SEPARATOR).map { it.trim() }
            if (carNames.any { carName: String -> carName.length > MAX_CAR_NAME_LENGTH }) {
                throw IllegalArgumentException(ERROR_MESSAGE_OVER_MAX_CAR_NAME_LENGTH)
            }
            return carNames.map { carName: String -> Car(carName) }
        }
    }
}
