package racing.model

import racing.util.NumberGenerator

class RacingGame {
    private val cars = mutableListOf<Car>()

    fun getCars() = cars.toList()

    fun initRacing(cars: List<Car>) {
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

    fun move() {
        for (car in cars) {
            car.move()
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
