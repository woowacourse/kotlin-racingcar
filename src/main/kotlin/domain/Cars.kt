package domain

import domain.move.MoveStrategy
import java.util.stream.Collectors

data class Cars(val cars: List<Car>) {

    companion object {
        fun from(carNames: List<String>): Cars {
            val cars = carNames.stream()
                .map { carName: String -> Car(carName) }
                .collect(Collectors.toList<Car>())
            return Cars(cars)
        }
    }

    fun getWinners(): List<String> {
        val maxPosition = getMaxPosition()

        return cars.stream()
            .filter { car: Car -> car.position == maxPosition }
            .map { car: Car -> car.name }
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
            .forEach { car: Car -> car.move(moveStrategy.isMovable()) }
    }
}
