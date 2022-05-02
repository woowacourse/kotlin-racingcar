package racingcar.domain

class RandomMoveStrategy : MoveStrategy {

    override fun canGO(): Boolean {
        val number = (0..9).random()
        return number >= 4
    }
}
