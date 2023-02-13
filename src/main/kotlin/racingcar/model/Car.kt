package racingcar.model

import racingcar.utils.MAX_CAR_NAME_LENGTH
import racingcar.utils.MIN_CAR_NAME_LENGTH
import racingcar.utils.RacingRuleValidator

class Car(
    val name: String,
    private var position: Int = 0
) : Comparable<Car> {

    init {
        val validator = RacingRuleValidator()
        require(validator.isValidateCarNameLength(name)) { CAR_NAME_BOUNDARY_ERROR_MESSAGE }
    }

    override fun compareTo(other: Car) = this.position - other.position

    override fun equals(other: Any?): Boolean {
        if (other is Car) {
            return this.position == other.position
        }

        return false
    }

    override fun toString() = name

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }

    fun move(isMove: Boolean) {
        if (isMove) setPosition(position + 1)
    }

    private fun setPosition(newPosition: Int) {
        position = newPosition
    }
    fun move() = ++position

    fun getPositionAsDash() = STRAIGHT_GAUGE.repeat(position)

    companion object {
        const val STRAIGHT_GAUGE = "-"

        const val CAR_NAME_BOUNDARY_ERROR_MESSAGE = "자동차 이름의 길이는 $MIN_CAR_NAME_LENGTH 이상 $MAX_CAR_NAME_LENGTH 이하로 부탁이요~"
    }
}
