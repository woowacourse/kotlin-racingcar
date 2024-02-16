data class RaceCar(
    val name: String,
) : Comparable<RaceCar> {
    private var position: Int = 0

    init {
        require(name.length <= 5) {
            "자동차 이름은 5자를 초과할 수 없다."
        }
    }

    fun moveOrStop(score: Int): Boolean {
        if (score in UNDER_BOUND..UPPER_BOUND) {
            position++
            return true
        }
        return false
    }

    override fun compareTo(other: RaceCar) = (position - other.position)

    override fun toString(): String = "$name : ${DISTANCE_UNIT.repeat(position)}"

    companion object {
        private const val DISTANCE_UNIT = "-"
        private const val UNDER_BOUND = 5
        private const val UPPER_BOUND = 9
    }
}
