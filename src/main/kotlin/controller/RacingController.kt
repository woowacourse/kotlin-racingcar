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
        val (attemptCount, carsManager) = raceInitialize()
        racePlay(attemptCount, carsManager)
        raceResult(carsManager)
    }

    private fun racePlay(attemptCount: Int, carsManager: CarsManager) {
        outputView.printResultComment()
        repeat(attemptCount) {
            carsManager.move()
            outputView.printRoundResult(carsManager.cars)
        }
    }

    private fun raceInitialize(): Pair<Int, CarsManager> {
        val carsName = inputView.readCarsName()
        val attemptCount = inputView.readAttemptCount()
        val carsManager = CarsManager(carsName, RandomNumber())
        return Pair(attemptCount, carsManager)
    }

    private fun raceResult(carsManager: CarsManager) {
        outputView.printWinners(carsManager.getWinners())
    }
}