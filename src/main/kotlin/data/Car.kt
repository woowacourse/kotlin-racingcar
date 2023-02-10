package data

class Car(
    val name: String,
    position: Int = 0
) {
    var position: Int = position
        private set

    init {
        require(name.length <= CAR_NAME_MAX) {
            CAR_NAME_ERROR_MSG
        }
    }

    fun move() {
        position++
    }

    companion object {
        const val CAR_NAME_MAX = 5
        const val CAR_NAME_ERROR_MSG = "[ERROR] 자동차 이름은 5자를 초과할 수 없다."
    }
}
