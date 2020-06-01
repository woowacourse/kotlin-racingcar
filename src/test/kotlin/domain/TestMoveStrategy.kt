package domain

class TestMoveStrategy(private val value: Int) : MoveStrategy {
    override fun canMove() = value >= MoveStrategy.THRESHOLD
}
