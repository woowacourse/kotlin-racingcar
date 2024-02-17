package domain

data class Car(val name: String) {
    var position: Int = DEFAULT_POSITION
        private set

    init {
        require(name.isNotBlank()) { EXCEPTION_CAR_NAME_IS_BLANK }
        require(name.length <= MAX_NAME_LENGTH) { EXCEPTION_INVALID_CAR_NAME_LENGTH }
    }

    fun move() {
        position++
    }

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val MAX_NAME_LENGTH = 5
        private const val EXCEPTION_CAR_NAME_IS_BLANK = "자동차 이름은 공백을 허용하지 않습니다"
        private const val EXCEPTION_INVALID_CAR_NAME_LENGTH = "자동차 이름은 $MAX_NAME_LENGTH 글자 이하여야 합니다"
    }
}
