package domain

data class Car(val name: String, val numberGenerator: NumberGenerator) {

    var position: Int = 0
        private set

    init {
        require(name.isNotBlank()) { "자동차 이름은 공백을 허용하지 않습니다" }
        require(name.length <= 5) { "자동차 이름은 다섯글자 이하여야 합니다" }
    }

    fun moveIfPossible() {
        if (canMove()) position++
    }

    private fun canMove(): Boolean = numberGenerator.generate() >= MOVE_LOWER_BOUND

    companion object {
        private const val MOVE_LOWER_BOUND = 4
    }
}
