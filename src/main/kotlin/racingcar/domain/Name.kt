package racingcar.domain

data class Name(val value: String) {

    init {
        validateLength()
        validateBlank()
    }

    private fun validateBlank() {
        if (value.isBlank()) {
            throw IllegalArgumentException("이름은 비어있을 수 없습니다.")
        }
    }

    private fun validateLength() {
        if (value.length > 5) {
            throw IllegalArgumentException("이름은 5자 이하여야 합니다.")
        }
    }
}