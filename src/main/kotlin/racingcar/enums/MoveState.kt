package racingcar.enums

enum class MoveState {
    MOVABLE,
    UNMOVABLE,
    ;

    companion object {
        private const val MOVEMENT_CRITERIA = 4

        fun create(value: Int): MoveState {
            if (value >= MOVEMENT_CRITERIA) return MOVABLE
            return UNMOVABLE
        }
    }
}
