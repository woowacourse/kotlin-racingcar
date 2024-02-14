package racingcar.model

class Car(private val name: String) {
    private var forwardCount = 0

    fun forward() {
        forwardCount++
    }
}
