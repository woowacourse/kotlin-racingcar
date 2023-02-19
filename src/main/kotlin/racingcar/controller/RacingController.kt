package racingcar.controller

import racingcar.domain.Cars
import racingcar.view.InputView

class RacingController(
    private val inputView: InputView = InputView(),
    private val outputController: OutputController = OutputController(),
) {

    fun runRacing() {
        val cars = inputView.readCars()
        val roundCount = inputView.readRoundCount()

        runRounds(roundCount, cars)

        val winners = cars.getWinners()
        outputController.printWinners(winners.cars)
    }

    private fun runRounds(roundCount: Int, cars: Cars) {
        outputController.printRunResult()
        repeat(roundCount) {
            runRound(cars)
        }
    }

    private fun runRound(cars: Cars) {
        cars.moveCarsRandomly()
        outputController.printRoundResult(cars.cars)
    }
}
