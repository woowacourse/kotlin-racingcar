package domain

class RandomMoveStrategy : MoveStrategy {

    override fun canGO(): Boolean {
        val number = Math.random() * 10;
        return number >= 4
    }
}
