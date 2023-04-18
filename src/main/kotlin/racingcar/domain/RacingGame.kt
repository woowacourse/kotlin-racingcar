package racingcar.domain

class RacingGame(private val cars: Cars, private val round: Int, private val numberGenerator: NumberGenerator) {

    fun play() {
        for (i in 1..round) {
            cars.moveAll(numberGenerator)
        }
    }

    fun findWinningCars(): List<Car> {
        return cars.findWinningCars()
    }
}
