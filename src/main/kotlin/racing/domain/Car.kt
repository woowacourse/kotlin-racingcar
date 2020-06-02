package racing.domain

class Car(private val engine: Engine = RandomEngine(), var position: Position = Position()) {
    fun move() {
        if (engine.isMovable()) {
            position = position.moveForward()
        }
    }
}
