package vo

private const val MIN_NAME_LENGTH = 1
private const val MAX_NAME_LENGTH = 5

data class Name(val name: String) {
    init {
        require(name.isNotEmpty()) { "빈 문자열을 입력하면 안됩니다." }
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) {
            "자동차 이름의 길이는 한 글자 이상, 다섯 글자 이하여야합니다."
        }
    }
}
