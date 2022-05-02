package domain

import domain.move.MoveStrategy
import vo.Name
import vo.Position
import java.util.stream.Collectors

data class Cars(val cars: List<Car>) {

    companion object {
        fun from(carNames: List<String>): Cars {
            val cars = carNames.stream()
                .map { Car(Name(it)) }
                .collect(Collectors.toList<Car>())
            return Cars(cars)
        }
    }

    fun getWinners(): List<Name> {
        val maxPosition = getMaxPosition()

        return cars.stream()
            .filter { it.getPosition() == maxPosition.position }
            .map { it.name }
            .collect(Collectors.toList<Name>())
    }

    private fun getMaxPosition(): Position {
        return cars.stream()
            .map { it.position }
            .sorted()
            .findFirst()
            .orElseThrow { NoSuchElementException() }
    }

    fun moveCars(moveStrategy: MoveStrategy) {
        cars.stream()
            .forEach { car: Car -> car.move(moveStrategy.isMovable()) }
    }
}
