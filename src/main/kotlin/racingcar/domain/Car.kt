package racingcar.domain

data class Car(private val strategy: () -> Boolean = randomMoveStrategy, val name: String = DEFAULT_NAME) {
    var position: Int = 0
        private set

    init {
        require(name.length in 1..MAX_NAME_LENGTH) { "이름은 1 ~ 5 사이의 길이여야합니다." }
    }

    fun move() {
        if (strategy()) {
            position += MOVE_UNIT
        }
    }

    fun isSamePosition(position: Int): Boolean {
        return this.position == position
    }

    companion object {
        private const val DEFAULT_NAME = "abc"
        private const val MOVE_UNIT = 1
        private const val MAX_NAME_LENGTH = 5
    }
}
