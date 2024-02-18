package racingcar.model

fun interface MovementDecisionMaker {
    fun isMovable(num: Int): Boolean
}
