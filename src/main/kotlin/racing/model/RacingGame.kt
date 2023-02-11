package racing.model

import racing.util.NumberGenerator

class RacingGame(val cars: List<Car>) {

    fun getWinnerNames(): List<String> {
        val maxPosition: Int = getMaxPosition()
        val winners: List<Car> = cars.filter { car: Car -> car.position == maxPosition }
        return winners.map { car: Car -> car.name }
    }

    private fun getMaxPosition(): Int {
        return cars.maxBy { car: Car -> car.position }.position
    }

    fun moveCars() {
        for ((index, car) in cars.withIndex()) {
            val randomNumbers: List<Int> = createRandomNumbers()
            car.move(randomNumbers[index])
        }
    }

    fun createRandomNumbers(): List<Int> {
        val result = mutableListOf<Int>()
        repeat(cars.size) {
            result.add(numberGenerator.generate())
        }
        return result
    }

    companion object {
        private val numberGenerator = NumberGenerator()
    }
}
