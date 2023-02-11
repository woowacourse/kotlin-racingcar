package racing.model

import racing.util.NumberGenerator

class RacingGame(private val _cars: MutableList<Car>) {

    val cars: List<Car>
        get() {
            return _cars
        }

    fun getWinnerNames(): List<String> {
        val maxPosition: Int = _cars.maxBy { car: Car -> car.position }.position
        val winners: List<Car> = _cars.filter { car: Car -> car.position == maxPosition }
        return winners.map { car: Car -> car.name }
    }

    fun moveCars(randomNumbers: List<Int>) {
        for ((index, car) in _cars.withIndex()) {
            car.move(randomNumbers[index])
        }
    }

    fun createRandomNumbers(count: Int): List<Int> {
        val result = mutableListOf<Int>()
        repeat(count) {
            result.add(numberGenerator.generate())
        }
        return result
    }

    companion object {
        private val numberGenerator = NumberGenerator()
    }
}
