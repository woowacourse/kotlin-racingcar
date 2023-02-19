package racingcar.controller

import racingcar.domain.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView = InputView(),
    private val outView: OutputView = OutputView(),
) {

    fun runRacing() {
        val cars = inputView.readCars()
        val roundCount = inputView.readRoundCount()

        runRounds(roundCount, cars)

        val winners = cars.getWinners()
        outView.printWinners(winners.cars)
    }

    private fun runRounds(roundCount: Int, cars: Cars) {
        outView.printRunResult()
        repeat(roundCount) {
            runRound(cars)
        }
    }

    private fun runRound(cars: Cars) {
        cars.moveCarsRandomly()
        outView.printRoundResult(cars)
    }
}
