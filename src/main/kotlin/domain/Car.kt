package domain

class Car(
    val name: String,
) {
    var position: Int = INIT_POSITION
        private set

    init {
        require(name.isNotBlank()) { "잘못 입력된 자동차 이름 -> $name : 자동차 이름은 공백이 불가합니다." }
        require(name.length <= 5) { "잘못 입력된 자동차 이름 -> $name : 자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun move(randomNum: Int) {
        if (randomNum >= MOVEMENT_THRESHOLD) {
            position++
        }
    }

    companion object {
        const val INIT_POSITION = 0
        const val MOVEMENT_THRESHOLD = 4
    }
}
