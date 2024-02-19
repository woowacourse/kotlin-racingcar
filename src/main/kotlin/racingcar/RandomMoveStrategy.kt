package racingcar

interface RandomMoveStrategy {
    fun shouldMove(
        minNum: Int,
        maxNum: Int,
    ): Boolean
}
