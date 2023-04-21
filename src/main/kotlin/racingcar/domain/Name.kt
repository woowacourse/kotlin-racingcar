package racingcar.domain

data class Name(
    val value: String,
) {

    init {
        require(value.length <= 5) { "이름은 5자 이하만 가능합니다" }
    }
}
