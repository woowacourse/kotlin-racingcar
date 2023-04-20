package racingCar.domain

data class Name(val name: String) {
    init {
        require(name.isEmpty() || name.length > 5) { throw IllegalArgumentException("이름을 다시 입력해주세요") }
    }
}
