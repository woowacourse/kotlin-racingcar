package controller

import model.CarsManager
import model.RandomNumber
import view.InputView
import view.OutputView

class RacingController(
) {

    fun run() {
        val carsName = InputView.readCarsName()
        val attemptCount = InputView.readAttemptCount()

        val carsManager = CarsManager(carsName, RandomNumber())
        OutputView.printResultComment()
        repeat(attemptCount) {
            carsManager.move()
            OutputView.printRoundResult(carsManager.cars)
        }

        OutputView.printWinners(carsManager.getWinners())
    }
}
