package racingcar.model

import racingcar.domain.CarName

class Car(
    val name: CarName,
    private var position: Int = 0
) : Comparable<Car> {

    override fun compareTo(other: Car) = this.position - other.position

    override fun equals(other: Any?): Boolean {
        if (other is Car) {
            return this.position == other.position
        }

        return false
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }

    override fun toString() = name.toString()

    fun getPositionAsDash() = STRAIGHT_GAUGE.repeat(position)

    fun move(isMove: Boolean) {
        if (isMove) setPosition(position + 1)
    }

    private fun setPosition(newPosition: Int) {
        position = newPosition
    }

    companion object {
        private const val STRAIGHT_GAUGE = "-"
    }
}
