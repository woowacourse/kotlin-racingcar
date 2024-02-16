data class RaceCar(
    val name: String,
    private var position: Int = DEFAULT_START_POSITION,
) : Comparable<RaceCar> {

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
        private const val DEFAULT_START_POSITION = 0
        private const val DISTANCE_UNIT = "-"
        private const val UNDER_BOUND = 5
        private const val UPPER_BOUND = 9
    }
}
