package racingcar.model

class Car(private val name: String) {
    var forwardCount = 0
        private set

    fun forward() {
        forwardCount++
    }

    override fun toString() = name
}
