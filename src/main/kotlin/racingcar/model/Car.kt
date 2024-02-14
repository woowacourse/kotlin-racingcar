package racingcar.model

class Car(private val name: String) {
    private var forwardCount = 0

    fun forward() {
        forwardCount++
    }

    override fun toString(): String {
        return "$name : ${FORWARD_SYMBOL.repeat(forwardCount)}"
    }

    companion object {
        private const val FORWARD_SYMBOL = "-"
    }
}
