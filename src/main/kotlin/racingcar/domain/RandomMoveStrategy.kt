package racingcar.domain

open class RandomMoveStrategy:MoveStrategy {
    override fun isMovable(): Boolean {
        val randomNumber = Math.random() * 10 + 1
        if(randomNumber>=4){
            return true
        }
        return false
    }
}