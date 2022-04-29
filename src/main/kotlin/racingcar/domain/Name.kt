package racingcar.domain

data class Name(val value: String) {

    init {
        require(value.isNotBlank()) { "이름은 비어있을 수 없습니다." }
        require(value.length <= 5) { "이름은 5자 이하여야 합니다." }
    }
}