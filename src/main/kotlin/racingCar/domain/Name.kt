package racingCar.domain

data class Name(val name: String) {

    private val MIN_NAME_LENGTH = 1
    private val MAX_NAME_LENGTH = 5

    init {
        require(name.isNotEmpty()) { "[ERROR] 빈 문자열을 입력하면 안됩니다." }
        require(name.length >= MIN_NAME_LENGTH && name.length <= MAX_NAME_LENGTH) { "[ERROR] 자동차 이름의 길이는 한 글자 이상, 다섯 글자 이하여야합니다." }
    }

    override fun toString(): String {
        return name
    }
}
