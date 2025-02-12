package model

class Car(
    val name: String,
    private var _position: Int = INIT_POSITION,
) {
    init {
        validateCar(name)
    }

    val position: Int
        get() = _position

    fun moveForward(number: Int) {
        if (number >= MINIMUM_MOVE_POINT) _position++
    }

    private fun validateCar(name: String) {
        require(name.trim().isNotEmpty()) { "자동차 이름이 올바르지 않습니다." }
        require(name.length <= MAX_NAME_LENGTH) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    companion object {
        const val MAX_NAME_LENGTH = 5
        const val MINIMUM_MOVE_POINT = 4
        const val INIT_POSITION = 0
    }
}
