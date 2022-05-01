package domain

import domain.move.MoveStrategy

data class Car(val name: Name, val position: Position = Position()) {

    fun move(strategy: MoveStrategy): Car {
        return Car(name, position.move(strategy))
    }
}
