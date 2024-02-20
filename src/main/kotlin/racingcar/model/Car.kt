package racingcar.model

class Car(val name: String, position: Int = DEFAULT_POSITION) {
    var position: Int = position
        private set

    init {
        require(name.isNotBlank()) { NAME_LENGTH_ERROR_MESSAGE }
        require(name.length in MINIMUM_OF_NAME_LENGTH..MAXIMUM_OF_NAME_LENGTH) { NAME_FORMAT_ERROR_MESSAGE }
    }

    fun move(number: Int) {
        if (number >= MOVE_CONDITION) position += 1
    }

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val MINIMUM_OF_NAME_LENGTH = 1
        private const val MAXIMUM_OF_NAME_LENGTH = 5
        private const val MOVE_CONDITION = 4
        private const val NAME_LENGTH_ERROR_MESSAGE = "자동차 이름 길이는 1 ~ 5여야 합니다."
        private const val NAME_FORMAT_ERROR_MESSAGE = "자동차 이름에 공백이 있으면 안됩니다."
    }
}
