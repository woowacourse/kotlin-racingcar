package model

class Car(
    val name: String,
    private val racingNumberGenerator: () -> Int
) {
    var position = INITIAL_POSITION
        private set

    init {
        require(name.length <= NAME_LENGTH_LIMIT) {
            CAR_NAME_ERROR
        }
    }

    fun move() {
        if (racingNumberGenerator() >= MINIMUM_NUMBER_TO_MOVE) {
            position++
        }
    }

    companion object {
        private const val NAME_LENGTH_LIMIT = 5
        private const val MINIMUM_NUMBER_TO_MOVE = 4
        private const val INITIAL_POSITION = 0
        private const val CAR_NAME_ERROR = "[ERROR] 자동차 이름은 5자를 초과할 수 없습니다."
    }
}
