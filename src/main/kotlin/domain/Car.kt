package domain

data class Car(val name: String) {
    init {
        require(name.isNotBlank()) { "자동차 이름은 공백을 허용하지 않습니다" }
        require(name.length <= 5) { "자동차 이름은 다섯글자 이하여야 합니다" }
    }
}
