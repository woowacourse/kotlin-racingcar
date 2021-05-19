package racingcar.domain

class Car(private val strategy: MoveStrategy) {
    private var position: Int = 0

    fun move() {
        if(strategy.isMovable()){
            position += 1
        }
    }

    fun isSamePosition(position: Int): Boolean {
        return this.position == position
    }

}