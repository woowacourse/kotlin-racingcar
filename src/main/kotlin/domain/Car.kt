package domain

class Car(val name: String) {

    var position: Int = 0

    init {
        require(name.isNotBlank()) { "이름은 공백일 수 없습니다." }
        require(name.length <= NAME_MIN_LENGTH) { "이름은 공백일 수 없습니다." }
    }

    companion object {
        private const val NAME_MIN_LENGTH = 5
    }
}