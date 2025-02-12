class Car(
    val name: String,
) {
    init {
        require(name.length in 1..5) { "[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다." }
        require(name.isNotBlank()) { "[ERROR] 자동차 이름은 공백일 수 없습니다." }
    }

    var position: Int = 0
        private set

    fun moveForward() {
        position++
    }
}
