package model

class Car(
    val name: String,
    position: Int = INIT_POSITION,
) {
    var position: Int = position
        private set

    init {
        validateCar(name)
    }

    fun moveForward(number: Int) {
        if (number >= MINIMUM_MOVE_POINT) position++
    }

    private fun validateCar(name: String) {
        require(name.trim().isNotEmpty()) { "자동차 이름에 빈 값이 입력되었습니다." }
        require(name.length <= MAX_NAME_LENGTH) { "자동차 이름이 5자를 초과하였습니다." }
    }

    companion object {
        const val MAX_NAME_LENGTH = 5
        const val MINIMUM_MOVE_POINT = 4
        const val INIT_POSITION = 0
    }
}
