package racingcar.domain

import racingcar.utils.MAX_CAR_NAME_LENGTH
import racingcar.utils.MIN_CAR_NAME_LENGTH

class Car(
    val name: String,
    private var position: Int = 0
) : Comparable<Car> {

    init {
        require(checkNameLength()) { CAR_NAME_BOUNDARY_ERROR_MESSAGE }
    }

    override fun compareTo(other: Car) = this.position - other.position

    override fun equals(other: Any?): Boolean {
        other as Car

        if (this.name == other.name) return true
        if (this.position == other.position) return true

        return false
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }

    override fun toString() = name

    fun getPosition() = position

    fun getPositionAsDash() = STRAIGHT_GAUGE.repeat(position)

    fun takeOneStepForward() = ++position

    private fun checkNameLength(): Boolean = name.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH

    companion object {
        private const val CAR_NAME_BOUNDARY_ERROR_MESSAGE =
            "자동차 이름의 길이는 $MIN_CAR_NAME_LENGTH 이상 $MAX_CAR_NAME_LENGTH 이하로 부탁이요~"

        private const val STRAIGHT_GAUGE = "-"
    }
}
