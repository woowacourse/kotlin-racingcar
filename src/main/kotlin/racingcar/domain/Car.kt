package racingcar.domain

data class Car(val name: Name, private var position: Position = Position()) {

    constructor(name: String, position: Int = 0) : this(Name(name), Position(position))

    fun moveForward(strategy: MovingStrategy) {
        position = position.increase(strategy)
    }

    fun isSamePosition(position: Position): Boolean {
        return this.position == position
    }
}
