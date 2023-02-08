package domain

class RandomMovingStrategy : MovingStrategy {
    override fun isMovable(): Boolean = (0..9).random() >= 4
}
