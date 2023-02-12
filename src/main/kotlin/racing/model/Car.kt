package racing.model

private const val PREFIX = "[Error]"

class Car(val name: String) {
    var position = 0
        private set

    init {
        require(name.length <= MAX_CAR_NAME_LENGTH) { "$PREFIX $name 자동차 이름은 ${MAX_CAR_NAME_LENGTH}글자까지 가능합니다." }
    }

    fun move(randomNumber: Int) {
        if (checkMove(randomNumber)) position++
    }

    private fun checkMove(randomNumber: Int): Boolean {
        return randomNumber >= CAN_MOVE_MINIMUM
    }

    companion object {
        private const val CAN_MOVE_MINIMUM = 4
        private const val MAX_CAR_NAME_LENGTH = 5
    }
}
