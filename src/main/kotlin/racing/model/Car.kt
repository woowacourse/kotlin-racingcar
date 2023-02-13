package racing.model

class Car(private val name: String) {
    var position = 0
        private set

    init {
        require(name.length <= 5) { "[ERROR] 자동차 이름은 5글자까지 가능합니다." }
        require(name.isNotEmpty()) { "[ERROR] 자동차 이름은 빈값이 될 수 없습니다." }
    }

    fun getName() = name

    fun move(conditionNumber: Int) {
        if (checkMove(conditionNumber)) position++
    }

    private fun checkMove(conditionNumber: Int) = conditionNumber >= CAN_MOVE_MINIMUM

    companion object {
        private const val CAN_MOVE_MINIMUM = 4
    }
}
