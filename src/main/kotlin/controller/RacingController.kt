package controller

import model.Racing
import model.RandomNumber
import view.InputView
import view.OutputView

class RacingController {

    fun run() {
        val carsName = InputView.readCarsName()
        val attemptCount = InputView.readAttemptCount()

        val racing = Racing(carsName, RandomNumber())
        OutputView.printResultComment()
        repeat(attemptCount) {
            racing.move()
            OutputView.printRoundResult(racing.cars)
        }

        OutputView.printWinners(racing.getWinners())
    }
}
