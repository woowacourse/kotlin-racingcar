class RaceCar(
    val name: String,
) : Comparable<RaceCar> {

    private var distance: Int = 0

    init {
        require(name.length <= 5) {
            "${name}은 5자를 초과합니다. 자동차 이름은 5자를 초과할 수 없습니다."
        }
    }

    constructor(name: String, initialDistance: Int) : this(name) {
        distance = initialDistance
    }

    fun moveOrStop(score: Int) {
        if (score in UNDER_BOUND..UPPER_BOUND) {
            distance++
        }
    }

    fun isSamePosition(other: RaceCar) = compareTo(other) == 0

    override fun compareTo(other: RaceCar) = (distance - other.distance)

    override fun toString(): String = "$name : ${DISTANCE_UNIT.repeat(distance)}"

    companion object {
        private const val DISTANCE_UNIT = "-"
        private const val UNDER_BOUND = 5
        private const val UPPER_BOUND = 9
    }
}
