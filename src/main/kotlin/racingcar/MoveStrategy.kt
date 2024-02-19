package racingcar

interface MoveStrategy {
    fun shouldMove(randomBound: Pair<Int, Int>): Boolean
}
