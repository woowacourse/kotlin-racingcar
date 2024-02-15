package racingcar.model

class Car(private val name: String) : Comparable<Car> {
    private var forwardCount = 0

    fun forward() {
        forwardCount++
    }

    override fun toString() = name

    fun getStepState() = "$name : ${FORWARD_SYMBOL.repeat(forwardCount)}"

    override fun compareTo(other: Car) =
        other.forwardCount.compareTo(this.forwardCount)

    companion object {
        private const val FORWARD_SYMBOL = "-"
    }
}
