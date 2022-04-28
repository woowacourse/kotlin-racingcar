package racingcar

import java.util.stream.Collectors

class GameResult(private val cars: Cars) {

    fun pickWinners(): List<String> {
        val rawCars = cars.cars
        val max = calculateMaxPosition(rawCars)
        return rawCars.stream()
            .filter { it.isSamePosition(max) }
            .map { it.name }
            .collect(Collectors.toList())
    }

    private fun calculateMaxPosition(cars: List<Car>) = cars.stream()
        .mapToInt { it.position }
        .max()
        .orElseThrow { throw IllegalArgumentException("[ERROR] 승자를 계산할 수 없습니다.") }
}
