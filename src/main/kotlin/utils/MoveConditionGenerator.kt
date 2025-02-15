package utils

object MoveConditionGenerator {
    fun getMoveConditionByNumber(number: Int): Boolean {
        return number < MOVE_CONDITION
    }

    private const val MOVE_CONDITION = 4
}
