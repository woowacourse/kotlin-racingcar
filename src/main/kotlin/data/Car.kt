package data

class Car(
    private var position: Int,
    private val name: String
) {

    init {
        require(name.length <= CAR_NAME_MAX) {
            CAR_NAME_ERROR_MSG
        }
    }

    fun move() {
        position++
    }

    fun getCar(): Pair<String, Int> {
        return Pair(name, position)
    }

    companion object {
        const val CAR_NAME_MAX = 5
        const val CAR_NAME_ERROR_MSG = "[ERROR] 자동차 이름은 5자를 초과할 수 없다."
    }
}
