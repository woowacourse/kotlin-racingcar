package domain

class Car(val name: String, moveCount: Int = 0) {
    var moveCount = moveCount
        private set

    init {
        require(name.length <= MAX_NAME_LENGTH) { NAME_LENGTH_ERROR }
        require(name.isNotEmpty()) { INVALID_NAME_ERROR }
    }

    private fun move() {
        moveCount++
    }

    fun tryMove(number: Int) {
        if (number >= MIN_MOVE_NUMBER) move()
    }

    companion object {
        private const val ERROR = "[ERROR]"
        const val NAME_LENGTH_ERROR = "$ERROR 5자를 초과할 수 없습니다."
        const val INVALID_NAME_ERROR = "$ERROR 올바른 입력 형식이 아닙니다."
        private const val MIN_MOVE_NUMBER = 4
        const val MAX_NAME_LENGTH = 5
    }
}
