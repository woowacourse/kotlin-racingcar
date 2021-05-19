package racingcar.domain

data class Car(private val strategy: MoveStrategy, val name: String) {
    var position: Int = 0
        private set

    constructor(strategy: MoveStrategy) : this(strategy, DEFAULT_NAME)
    constructor(name: String) : this(RandomMoveStrategy, name)

    companion object {
        private const val DEFAULT_NAME = "abc"
        private const val MOVE_UNIT = 1
        private const val MAX_NAME_LENGTH = 5
    }

    fun move() {
        if (strategy.isMovable()) {
            position += MOVE_UNIT
        }
    }

    fun isSamePosition(position: Int): Boolean {
        return this.position == position
    }

    private fun validateName(name: String) {
        if (name.length > MAX_NAME_LENGTH || name.isEmpty()) {
            throw IllegalArgumentException("이름은 1 ~ 5 사이의 길이여야합니다.")
        }

    }

    init {
        validateName(name)
    }
}