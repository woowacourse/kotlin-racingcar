package racing.model

import racing.util.NumberGenerator

class RacingGame {
    private val cars = mutableListOf<Car>()

    fun getCars() = cars.toList()

    fun initRacing(cars: List<Car>) {
        this.cars.addAll(cars)
    }

    fun getWinners(): List<String> {
        cars.sortBy { it.position }
        val result = mutableListOf<String>()
        for (car in cars) {
            if (car.position == cars.last().position) result.add(car.name)
        }
        return result.toList()
    }

    fun moveCars(randomNumbers: List<Int>) {
        for ((index, car) in cars.withIndex()) {
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
