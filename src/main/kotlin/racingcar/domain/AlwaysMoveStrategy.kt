package racingcar.domain

class AlwaysMoveStrategy : MovingStrategy {

    override fun isMovable(): Boolean {
        return true
    }
}
