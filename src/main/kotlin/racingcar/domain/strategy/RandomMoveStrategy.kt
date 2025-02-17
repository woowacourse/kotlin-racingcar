package racingcar.domain.strategy

class RandomMoveStrategy : MoveStrategy {
    override fun isMove(): Boolean = (0..9).random() >= THRESHOLD

    companion object {
        private const val THRESHOLD = 4
    }
}
