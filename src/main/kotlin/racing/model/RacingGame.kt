package racing.model

import racing.util.NumberGenerator

class RacingGame {
    private val cars = mutableListOf<Car>()

    fun getCars() = cars.toList()

    fun initRacing(cars: List<Car>) {
        this.cars.clear()
        this.cars.addAll(cars)
    }

    fun getWinners(): List<String> {
        cars.sortBy { it.getPosition() }
        val result = mutableListOf<String>()
        for (car in cars) {
            if (car.getPosition() == cars.last().getPosition()) result.add(car.getName())
        }
        return result.toList()
    }

    fun race(maxMoveCount: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        repeat(maxMoveCount) {
            moveCars(createRandomNumbers(cars.size))
            result.add(getGameResultOneTurn())
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

    private fun moveCars(randomNumbers: List<Int>) { // 인자로 받을 필요없다
        for ((index, car) in cars.withIndex()) {
            car.move(randomNumbers[index])
        }
    }

    private fun createRandomNumbers(count: Int): List<Int> {
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
