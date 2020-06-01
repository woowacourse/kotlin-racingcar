package domain

data class Car(private var position: Position, private var moveStrategy: () -> Boolean) {
    fun move() {
        if (moveStrategy()) {
            position = position.move()
        }
    }

    fun position() = position.getPosition()
}