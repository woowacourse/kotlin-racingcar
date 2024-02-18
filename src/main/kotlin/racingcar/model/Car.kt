package racingcar.model

class Car(private val name: String) {
    var position = 0
        private set

    fun forward() {
        position++
    }

    override fun toString() = name
}
