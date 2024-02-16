package racingcar.model

class Car(private val name: String) : Comparable<Car> {
    var forwardCount = 0
        private set

    fun forward() {
        forwardCount++
    }

    override fun toString() = name

    override fun compareTo(other: Car) =
        other.forwardCount.compareTo(this.forwardCount)
}
