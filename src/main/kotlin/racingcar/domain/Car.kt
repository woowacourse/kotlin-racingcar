package racingcar.domain

private const val DEFAULT_NAME = "abc"
private const val MOVE_UNIT = 1
private const val MAX_NAME_LENGTH = 5

data class Car(
    private val strategy: MoveStrategy = RandomMoveStrategy,
    val name: String = DEFAULT_NAME
) {
    var position: Int = 0
        private set

    init {
        validateName(name)
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
        require(name.length <= MAX_NAME_LENGTH && name.isNotBlank()) {
            "이름은 1 ~ 5 사이의 길이여야합니다."
        }
    }
}
