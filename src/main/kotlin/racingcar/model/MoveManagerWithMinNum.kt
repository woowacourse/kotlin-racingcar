package racingcar.model

class MoveManagerWithMinNum(private val minNum: Int) : MoveManager {
    override fun isMoveAble(num: Int): Boolean = minNum <= num
}
