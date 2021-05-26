package racingcar.domain

@FunctionalInterface
interface MoveStrategy {
    fun isMovable(): Boolean
}
