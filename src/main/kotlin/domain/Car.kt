package domain

class Car(private val moveStrategy: MoveStrategy = RandomMoveStrategy(), private val position: Position = Position()) {
    fun move() {
        if (moveStrategy.canMove()) {
            position.moveForward()
        }
    }

    fun getPosition(): Int = position.value
}
