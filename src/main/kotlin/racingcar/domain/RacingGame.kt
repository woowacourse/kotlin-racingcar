package racingcar.domain

class RacingGame(private val cars: Cars, private var round: Int, private val numberGenerator: NumberGenerator) {

    fun findWinningCars(): List<Car> {
        return cars.findWinningCars()
    }

    fun playOneRound(): List<Car> {
        cars.moveAll(numberGenerator)
        round--
        return cars.cars
    }

    fun isNotEnd(): Boolean {
        return round > 0
    }
}
