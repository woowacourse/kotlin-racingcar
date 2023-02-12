package racing.model

import racing.util.NumberGenerator
import racing.util.RandomNumberGenerator

class RacingGame {
    private val cars = mutableListOf<Car>()

    fun getCars() = cars.toList()

    fun initRacing(cars: List<Car>) {
        this.cars.clear()
        this.cars.addAll(cars)
    }

    fun race(maxMoveCount: Int, randomGenerator: RandomNumberGenerator = NumberGenerator()): List<List<Int>> {
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

    private fun createRandomNumbers(count: Int, randomGenerator: RandomNumberGenerator = NumberGenerator()): List<Int> {
        val result = mutableListOf<Int>()
        repeat(count) {
            result.add(randomGenerator.generate())
        }
        return result
    }

    private fun getGameResultOneTurn(): List<Int> {
        val result = mutableListOf<Int>()
        cars.map {
            result.add(it.getPosition())
        }
        return result
    }

    fun getWinners(): List<String> {
        val result = mutableListOf<String>()
        val winnerPosition = cars.maxOf { it.getPosition() }
        cars.map {
            if (it.getPosition() == winnerPosition) result.add(it.getName())
        }
        return result.toList()
    }
}
