package racingcar.enums

enum class Move {
    MOVABLE,
    UNMOVABLE,
    ;

    companion object {
        private const val MOVEMENT_CRITERIA = 4

        fun create(value: Int): Move {
            if (value >= MOVEMENT_CRITERIA) return MOVABLE
            return UNMOVABLE
        }
    }
}
