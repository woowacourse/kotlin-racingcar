package racingcar.domain

class Car(val name: Name, private var position: Position) {

    constructor(name: String, position: Int) : this(Name(name), Position(position))

    fun moveForward() {
        position = position.increase()
    }

    fun isSamePosition(position: Position): Boolean {
        return this.position == position
    }
}
