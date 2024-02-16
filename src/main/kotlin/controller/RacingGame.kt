package controller

import domain.Cars
import domain.MoveStrategy
import domain.NumberGenerator
import domain.TryCount
import view.InputView
import view.OutputView

class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val numberGenerator: NumberGenerator,
    private val moveStrategy: MoveStrategy,
) {
    fun start() {
        val cars = readCars()
        val tryCount = readTryCount()

        race(cars, tryCount)
    }

    private fun readCars(): Cars = Cars.from(inputView.readCars(), numberGenerator)

    private fun readTryCount(): TryCount = TryCount.from(inputView.readTryCount())

    private fun race(
        cars: Cars,
        tryCount: TryCount,
    ) {
        outputView.printResultHeader()
        repeat(tryCount.count) {
            cars.startPhaseWith(moveStrategy)
            outputView.printPhase(cars)
        }
        outputView.printWinner(cars)
    }
}
