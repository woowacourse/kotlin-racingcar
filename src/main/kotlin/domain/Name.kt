package domain

data class Name(
    val value: String
) {
    init {
        require(value.isNotEmpty() && value.length <= 5) { "자동차 이름은 1자 이상, 5자 이하여야 합니다." }
    }
}
