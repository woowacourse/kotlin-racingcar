package domain

data class Car(val name: String, val numberGenerator: NumberGenerator) {
    var position: Int = INIT_POSITION
        private set

    init {
        require(name.isNotBlank()) { EXCEPTION_CAR_NAME_IS_BLANK }
        require(name.length <= NAME_UPPER_BOUND) { EXCEPTION_INVALID_CAR_NAME_LENGTH }
    }

    fun moveIfPossible() {
        if (canMove()) position++
    }

    private fun canMove(): Boolean = numberGenerator.generate() >= MOVE_LOWER_BOUND

    companion object {
        private const val INIT_POSITION = 0
        private const val MOVE_LOWER_BOUND = 4
        private const val NAME_UPPER_BOUND = 5
        private const val EXCEPTION_CAR_NAME_IS_BLANK = "자동차 이름은 공백을 허용하지 않습니다"
        private const val EXCEPTION_INVALID_CAR_NAME_LENGTH = "자동차 이름은 다섯글자 이하여야 합니다"
    }
}
