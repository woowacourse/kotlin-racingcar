package data

import util.CAR_NAME_ERROR_MSG

class Car(
    private var position: Int,
    private val name: String
) {

    init {
        require(name.length <= 5) {
            CAR_NAME_ERROR_MSG
        }
    }

    fun move() {
        position++
    }

    fun getCar(): Pair<String, Int> {
        return Pair(name, position)
    }
}
