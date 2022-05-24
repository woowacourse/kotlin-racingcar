package racingcar

class Car(val name: String) {
    var position = 0
        private set

    init {
        require(name.length <= 5)
    }

    fun move(x: Int) {
        if (x >= MOVABLE_BOUND) position += 1
    }

    companion object {
        private const val MOVABLE_BOUND = 4
    }
}
