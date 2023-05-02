package racingcar.domain

private const val MINIMUM_POWER_TO_MOVE = 4
private const val MAXIMUM_POWER_TO_MOVE = 9

private const val MINIMUM_NAME_LENGTH = 1
private const val MAXIMUM_NAME_LENGTH = 5

class Car(val name: String, private var position: Int = 0) {

    init {
        require(name.length in MINIMUM_NAME_LENGTH..MAXIMUM_NAME_LENGTH) { "이름의 길이는 1 이상 5 이하입니다" }
        require(position >= 0) { "위치값은 0 이상이어야 합니다" }
    }

    fun move(power: Int) {
        if (power in MINIMUM_POWER_TO_MOVE..MAXIMUM_POWER_TO_MOVE) {
            position++
        }
    }

    fun getPosition(): Int {
        return position
    }

    companion object {
        fun from(name: String): Car {
            return Car(name.trim())
        }

        fun of(name: String, position: Int): Car {
            return Car(name.trim(), position)
        }
    }
}
