package domain

import java.util.stream.Collectors

data class Cars(val cars: List<Car>) {
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
}
