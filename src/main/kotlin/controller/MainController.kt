package controller

import view.InputView
import view.OutputView

class MainController {
    private val inOutController = ViewController(InputView(), OutputView())

    fun runProgram() {
        val cars = inOutController.getCarName()
        val raceController = RaceController(inOutController.getTryCount(), cars, inOutController)
        raceController.fullRace()
        val winnerList = raceController.getFinalResult()
        inOutController.printFinalResult(winnerList)
    }
}
