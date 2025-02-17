package model

data class Car(val name: String) {
    var position: Int = CAR_INITIAL_POSITION
        private set

    init {
        require(name.isNotEmpty()) { MESSAGE_CAR_NAME_EMPTY }
        require(name.length <= CAR_NAME_MAX_LENGTH) { MESSAGE_CAR_NAME_TOO_LONG }
    }

    constructor(name: String, position: Int) : this(name) {
        this.position = position
    }

    fun move(number: Int) {
        if (number >= CAR_MOVE_THRESHOLD) position++
    }

    fun getStatus(): String {
        return "$name : ${CAR_POSITION_INDICATOR.repeat(position)}\n"
    }

    companion object {
        private const val CAR_INITIAL_POSITION = 0
        private const val CAR_NAME_MAX_LENGTH = 5
        private const val CAR_MOVE_THRESHOLD = 4
        private const val CAR_POSITION_INDICATOR = "-"

        private const val MESSAGE_CAR_NAME_EMPTY = "자동차 이름은 공백일 수 없습니다."
        private const val MESSAGE_CAR_NAME_TOO_LONG = "자동차 이름은 최대 5자입니다."
    }
}
