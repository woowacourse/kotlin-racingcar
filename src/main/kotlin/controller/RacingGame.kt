package controller

import domain.Cars
import domain.NumberGenerator
import domain.TryCount
import view.InputView
import view.OutputView

class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val numberGenerator: NumberGenerator
) {

    fun start() {
        val cars = readCars()
        val tryCount = readTryCount()

        race(cars, tryCount)
        getWinners(cars)
    }

    private fun readCars(): Cars = Cars.from(inputView.readCars(), numberGenerator)

    private fun readTryCount(): TryCount = TryCount.from(inputView.readTryCount())

    private fun race(cars: Cars, tryCount: TryCount) {
        repeat(tryCount.count) {
            cars.startPhase()
            outputView.printPhase(cars)
        }
    }

    private fun getWinners(cars: Cars) {
        val winners = cars.getWinners()
        outputView.printResultHeader()
        outputView.printWinner(winners)
    }

}