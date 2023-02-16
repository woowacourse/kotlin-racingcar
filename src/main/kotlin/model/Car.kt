package model

class Car(
    val name: String,
    position: Int = CAR_START_POSITION
) {
    var position: Int = position
        private set

    init {
        require(name.length <= CAR_NAME_MAX) {
            "$CAR_NAME_NUMBER_ERROR_MSG $name 은 5자를 초과합니다."
        }
        require(name.isNotBlank()) {
            "$CAR_NAME_BLANK_ERROR_MSG $name 은 공백입니다."
        }
    }

    fun move(condition: Int): PathState {
        if (condition >= MOVE_LEAST_NUMBER) {
            position++
            return PathState.MOVE
        }

        return PathState.STOP
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        other as Car
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    companion object {
        const val CAR_START_POSITION = 0
        const val CAR_NAME_MAX = 5
        const val CAR_NAME_NUMBER_ERROR_MSG = "[ERROR] 자동차 이름은 5자를 초과할 수 없습니다."
        const val CAR_NAME_BLANK_ERROR_MSG = "[ERROR] 자동차 이름은 공백이 될 수 없습니다."
        const val MOVE_LEAST_NUMBER = 4
    }
}
