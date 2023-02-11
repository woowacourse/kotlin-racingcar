package racing.model

private const val PREFIX = "[Error]"

class Car(val name: String) {
    var position = 0
        private set

    init {
        require(name.length <= 5) { "$PREFIX 자동차 이름은 5글자까지 가능합니다." }
        require(name.isNotEmpty()) { "$PREFIX 자동차 이름은 빈값이 될 수 없습니다." }
    }

    fun move(randomNumber: Int) {
        if (checkMove(randomNumber)) position++
    }

    private fun checkMove(randomNumber: Int): Boolean {
        return randomNumber >= CAN_MOVE_MINIMUM
    }

    companion object {
        private const val CAN_MOVE_MINIMUM = 4
    }
}
