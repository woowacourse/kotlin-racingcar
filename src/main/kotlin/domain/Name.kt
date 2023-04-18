package domain

class Name(val value: String) {

    init {
        validateLength(value)
        validateBlank(value)
    }

    private fun validateLength(name: String) {
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5글자를 넘을 수 없습니다.")
        }
    }

    private fun validateBlank(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException("자동차 이름에 공백이 들어갈 수 없습니다.")
        }
    }
}
