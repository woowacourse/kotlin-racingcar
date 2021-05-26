package racingcar.domain

const val MINIMUM_NAME_LENGTH = 5;

data class Name(val value: String) {

    init {
        validate(value)
    }

    private fun validate(name: String) {
        require(name.isNotBlank()) { "이름은 공백일 수 없습니다." }
        require(name.length <= MINIMUM_NAME_LENGTH) { "이름은 5글자 이하입니다." }
    }
}