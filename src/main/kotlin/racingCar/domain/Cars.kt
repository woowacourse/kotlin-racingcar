package racingCar.domain

import racingCar.domain.move.MoveStrategy
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
            .filter { it.position == maxPosition }
            .map { it.name.toString() }
            .collect(Collectors.toList<String>())
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
            .forEach { it.move(moveStrategy) }
    }
}
