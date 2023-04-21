package domain

class Name(val value: String) {
    companion object {
        private const val MAX_LENGTH = 5
    }

    init {
        validateLength(value)
        validateBlank(value)
    }

    private fun validateLength(name: String) {
        require(name.length <= MAX_LENGTH) { "자동차 이름은 $MAX_LENGTH 글자를 넘을 수 없습니다." }
    }

    private fun validateBlank(name: String) {
        require(name.isNotBlank()) { "자동차 이름에 공백이 들어갈 수 없습니다." }
    }
}
