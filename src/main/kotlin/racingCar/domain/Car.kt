package racingCar.domain

import racingCar.domain.move.MoveStrategy

data class Car(val name: Name, val position: Position = Position()) {

    constructor(name: String, position: Int) : this (Name(name), Position(position))

    fun move(strategy: MoveStrategy) {
        position.move(strategy)
    }
}
