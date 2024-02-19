package racecar.domain

class RaceCar(
    val name: String,
    startPoint: Int = DEFAULT_START_POSITION,
    private val moveStrategy: MoveStrategy = defaultMoveStrategy,
) {
    var position: Int = startPoint
        private set

    init {
        if (name.any { it.isWhitespace() }) {
            throw IllegalArgumentException("빈 문자열을 포함할 수 없습니다.")
        }
        require(name.length in 1..5) {
            "자동차 이름은 1 ~ 5 길이 법위를 벗어날 수 없습니다."
        }
    }

    fun move(score: Int) {
        position += moveStrategy.move(score)
    }

    override fun toString(): String = "$name : ${DISTANCE_UNIT.repeat(position)}"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RaceCar

        if (name != other.name) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }

    fun interface MoveStrategy {
        fun move(score: Int): Int
    }

    companion object {
        private val defaultMoveStrategy =
            MoveStrategy { if (it in UNDER_BOUND..UPPER_BOUND) DEFAULT_OFFSET else STOP }
        private const val DEFAULT_OFFSET = 1
        private const val STOP = 0
        private const val DEFAULT_START_POSITION = 0
        private const val DISTANCE_UNIT = "-"
        private const val UNDER_BOUND = 5
        private const val UPPER_BOUND = 9
    }
}
