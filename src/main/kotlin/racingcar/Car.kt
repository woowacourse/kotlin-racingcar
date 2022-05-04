package racingcar

const val MAX_LENGTH = 5
const val MOVE_STANDARD = 4

data class Car(val name: String) {

    var position: Int = 0
        private set

    init {
        validateCarName(name)
    }

    private fun validateCarName(name: String) {
        require(name.isNotBlank()) { "[ERROR] 이름을 입력하지 않았습니다." }
        require(!name.contains(" ")) { "[ERROR] 이름에 공백이 존재합니다." }
        require(name.length in 0..MAX_LENGTH) { "[ERROR] 이름은 5자 이하로 입력하세요." }
    }

    fun move(moveFactor: Int) {
        if (moveFactor >= MOVE_STANDARD) {
            position++
        }
    }

    fun isSamePosition(position: Int): Boolean = position == this.position
}
