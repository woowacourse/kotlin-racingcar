class Car(
    val name: String,
) {
    var position: Int = INITIAL_CAR_POSITION
        private set

    init {
        require(name.isNotBlank()) { "[ERROR] 자동차 이름은 공백일 수 없습니다. (입력한 이름: $name)" }
        require(name.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) {
            "[ERROR] 자동차 이름은 ${MIN_CAR_NAME_LENGTH}자 이상 ${MAX_CAR_NAME_LENGTH}자 이하여야 합니다. (입력한 이름: $name)"
        }
    }

    fun moveForward(isMoved: Boolean) {
        if (isMoved) position++
    }

    companion object {
        private const val MIN_CAR_NAME_LENGTH = 1
        private const val MAX_CAR_NAME_LENGTH = 5
        private const val INITIAL_CAR_POSITION = 0
    }
}
