package racingcar.domain

data class Car(val name: Name, val position: Position = Position()) {

    constructor(name: String, position: Int = 0) : this(Name(name), Position(position))

    fun moveForward(strategy: MovingStrategy): Car {
        return Car(name, position.increase(strategy))
    }

    fun isSamePosition(position: Position): Boolean {
        return this.position == position
    }
}
