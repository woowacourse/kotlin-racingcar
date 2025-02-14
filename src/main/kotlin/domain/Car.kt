package domain

class Car(
    val name: String,
    position: Int = INIT_POSITION,
) {
    var position: Int = position
        private set

    init {
        require(name.length <= 5) { "각 자동차 이름은 5자를 초과할 수 없습니다." }
        require(name.isNotBlank()) { "각 자동차 이름은 공백이 불가합니다." }
    }

    fun moveOrStop(condition: Boolean) {
        if (condition) {
            ++position
        }
    }

    companion object {
        const val INIT_POSITION = 0
    }
}
