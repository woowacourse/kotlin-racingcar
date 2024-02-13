data class Car(
    val name: String,
) : Comparable<Car> {
    private var distance: Int = 0

    init {
        require(name.length <= 5) {
            "자동차 이름은 5자를 초과할 수 없다."
        }
    }

    fun moveOrStop(amount: Int) {
        if (amount <= UPPER_BOUND) return
        distance++
    }

    override fun compareTo(other: Car) = (distance - other.distance)

    override fun toString(): String = "$name : ${"-".repeat(distance)}"

    companion object {
        private const val UPPER_BOUND = 4
    }
}

