package controller

import model.CarsManager
import model.RandomNumber
import view.InputView
import view.OutputView

class RacingController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    fun run() {
        val carsName = inputView.readCarsName()
        val attemptCount = inputView.readAttemptCount()

        val carsManager = CarsManager(RandomNumber())
        carsManager.create(carsName)
        outputView.printResultComment()
        repeat(attemptCount) {
            carsManager.move()
            outputView.printRoundResult(carsManager.cars)
        }

        outputView.printWinners(carsManager.getWinners())
    }
}