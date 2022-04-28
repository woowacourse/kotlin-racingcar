package racingcar.domain

class FixedMoveStrategy(private val list: List<Int>) : MoveStrategy {

    private var index: Int = 0

    override fun canGO(): Boolean {
        return list[index++] >= 4
    }
}