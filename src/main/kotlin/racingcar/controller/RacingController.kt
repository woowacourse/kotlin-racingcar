package racingcar.controller

import racingcar.domain.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {

    fun runRacing() {
        val cars = inputView.readCars()
        val roundCount = inputView.readRoundCount()

        runRounds(roundCount.number, cars)

        val winners = cars.getWinners()
        outputView.printWinners(winners.cars)
    }

    private fun runRounds(roundCount: Int, cars: Cars) {
        outputView.printRunResult()
        repeat(roundCount) {
            runRound(cars)
        }
    }

    private fun runRound(cars: Cars) {
        cars.moveCarsRandomly()
        outputView.printRoundResult(cars)
    }
}
