package racingCar.domain

data class Name(val name: String) {
    init {
        require(name.isNotBlank() && name.length <= MAX) { OVER_MAX_NAME_SIZE }
    }

    companion object {
        private const val MAX: Int = 5
        private const val OVER_MAX_NAME_SIZE: String = "이름을 다시 입력해주세요"
    }
}
