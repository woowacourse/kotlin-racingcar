package racingcar

import racingcar.extension.times

class Car(
    val name: String,
    initialDistance: Int = 0,
) {
    var distance: Int = initialDistance
        private set

    fun move() {
        val random: Int = (0..9).random()
        if (isMovable(random)) {
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
        fun isMovable(random: Int): Boolean {
            // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
            return random >= 4
        }
    }
}
