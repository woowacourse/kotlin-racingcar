package domain

data class Car(val name: String) {
    var position: Int = 0
        private set

    init {
        require(name.isNotBlank()) { EXCEPTION_CAR_NAME_IS_BLANK }
        require(name.length <= 5) { EXCEPTION_INVALID_CAR_NAME_LENGTH }
    }

    fun move() {
        position++
    }

    companion object {
        private const val EXCEPTION_CAR_NAME_IS_BLANK = "자동차 이름은 공백을 허용하지 않습니다"
        private const val EXCEPTION_INVALID_CAR_NAME_LENGTH = "자동차 이름은 다섯글자 이하여야 합니다"
    }
}
