package racing.model

import racing.util.NumberGenerator
import racing.util.RandomNumberGenerator

class RacingGame(private val cars: List<Car>) {

    fun getCars() = cars.toList()

    fun race(maxMoveCount: Int, randomGenerator: NumberGenerator = RandomNumberGenerator()): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        repeat(maxMoveCount) {
            moveCars(createRandomNumbers(cars.size, randomGenerator))
            result.add(getGameResultOneTurn())
        }
        return result
    }

    private fun moveCars(randomNumbers: List<Int>) {
        for ((index, car) in cars.withIndex()) {
            car.move(randomNumbers[index])
        }
    }

    private fun createRandomNumbers(count: Int, randomGenerator: NumberGenerator = RandomNumberGenerator()): List<Int> {
        val result = mutableListOf<Int>()
        repeat(count) {
            result.add(randomGenerator.generate())
        }
        return result
    }

    private fun getGameResultOneTurn(): List<Int> {
        val result = mutableListOf<Int>()
        cars.forEach {
            result.add(it.position)
        }
        return result
    }

    fun getWinners(): List<String> {
        val result = mutableListOf<String>()
        val winnerPosition = cars.maxOf { it.position }
        cars.forEach {
            if (it.position == winnerPosition) result.add(it.getName())
        }
        return result.toList()
    }
}
