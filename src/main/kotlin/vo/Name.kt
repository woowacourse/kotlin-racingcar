package vo

data class Name(val name: String) {
    companion object {
        private const val MIN_NAME_LENGTH = 1
        private const val MAX_NAME_LENGTH = 5
    }

    init {
        require(name.isNotEmpty())
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) {
            "자동차 이름의 길이는 한 글자 이상, 다섯 글자 이하여야합니다."
        }
    }

    override fun toString(): String {
        return name
    }
}
