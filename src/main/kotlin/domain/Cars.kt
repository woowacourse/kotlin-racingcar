package domain

import domain.move.MoveStrategy
import vo.Name
import vo.Position

data class Cars(val cars: List<Car>) {

    fun getWinners(): List<Name> {
        return cars
            .filter { it.position.position == getMaxPosition().position }
            .map { it.name }
    }

    private fun getMaxPosition(): Position {
        return cars
            .map { it.position }.minOf { it }
    }

    fun moveCars(moveStrategy: MoveStrategy) {
        cars.forEach { car: Car -> car.move(moveStrategy.isMovable()) }
    }

    companion object {
        fun from(carNames: List<String>): Cars {
            return Cars(carNames.map { Car(Name(it)) })
        }
    }
}
