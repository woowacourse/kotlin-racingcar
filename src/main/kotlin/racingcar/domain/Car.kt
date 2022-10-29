package racingcar.domain

class Car(
    val name: Name,
    var position: Position = Position()
){

    constructor(name: String, position: Int = 0) : this(Name(name), Position(position))

    fun moveForward(strategy: MovingStrategy) {
        if (strategy.isMovable()) {
            this.position = position.increase(1)
        }
    }

    fun isSamePosition(position: Position): Boolean {
        return this.position == position
    }
}
