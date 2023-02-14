package racing.model

import racing.util.NumberGenerator
import racing.util.RandomNumberGenerator

class RacingGame(private val cars: List<Car>) {

    fun getCars() = cars.toList()

    fun race(maxMoveCount: Int, numberGenerator: NumberGenerator = RandomNumberGenerator()): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        repeat(maxMoveCount) {
            moveCars(numberGenerator)
            result.add(getGameResultOneTurn())
        }
        return result
    }

    private fun moveCars(numberGenerator: NumberGenerator = RandomNumberGenerator()) {
        cars.forEach {
            it.move(createRandomNumber(numberGenerator))
        }
    }

    private fun createRandomNumber(numberGenerator: NumberGenerator = RandomNumberGenerator()): Int {
        return numberGenerator.generate()
    }

    private fun getGameResultOneTurn(): List<Int> {
        return cars.map { it.position }
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
