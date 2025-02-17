package racingcar.domain.strategy

class FakeMoveStrategy(
    private val move: List<Boolean>,
) : MoveStrategy {
    private var index: Int = 0

    override fun isMove(): Boolean = move[index++]
}
