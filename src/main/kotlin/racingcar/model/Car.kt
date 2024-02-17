package racingcar.model

class Car(private val name: String) : Comparable<Car> {
    var position: Int = 0
        private set

    fun forward() {
        position++
    }

    override fun toString() = name

    override fun compareTo(other: Car) =
        other.position.compareTo(this.position)
}
