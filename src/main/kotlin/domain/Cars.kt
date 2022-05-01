package domain

import domain.move.MoveStrategy
import java.util.stream.Collectors

data class Cars(val cars: List<Car>) {

    companion object {
        fun from(carNames: List<Name>): Cars {
            val cars = carNames.stream()
                .map { Car(it) }
                .collect(Collectors.toList<Car>())
            return Cars(cars)
        }
    }

    fun getWinners(): List<String> {
        val maxPosition = getMaxPosition()

        return cars.stream()
            .filter { car -> car.position == maxPosition }
            .map { car -> car.name.toString() }
            .collect(Collectors.toList<String>())
    }

    private fun getMaxPosition(): Int {
        return cars.stream()
            .sorted()
            .findFirst()
            .orElseThrow { NoSuchElementException() }
            .position
    }

    fun moveCars(moveStrategy: MoveStrategy) {
        cars.stream()
            .forEach { it.move(moveStrategy.isMovable()) }
    }
}
