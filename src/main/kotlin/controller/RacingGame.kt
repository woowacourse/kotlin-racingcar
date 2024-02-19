package controller

import domain.Cars
import domain.NumberGenerator
import domain.TryCount
import view.InputView
import view.OutputView

class RacingGame(
    private val numberGenerator: NumberGenerator,
) {
    fun start() {
        val cars = readCars()
        val tryCount = readTryCount()

        race(cars, tryCount)
        getWinners(cars)
    }

    private fun readCars(): Cars = Cars.from(InputView.readCars(), numberGenerator)

    private fun readTryCount(): TryCount = TryCount.from(InputView.readTryCount())

    private fun race(
        cars: Cars,
        tryCount: TryCount,
    ) {
        repeat(tryCount.count) {
            cars.startPhase()
            OutputView.printPhase(cars)
        }
    }

    private fun getWinners(cars: Cars) {
        OutputView.printResultHeader()
        OutputView.printWinner(cars.getWinners())
    }
}
