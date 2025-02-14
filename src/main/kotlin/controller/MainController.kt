package controller

import view.InputView
import view.OutputView

class MainController {
    private val viewController = ViewController(InputView(), OutputView())

    fun runProgram() {
        val cars = viewController.getCarName()
        val raceController = RaceController(viewController.getTryCount(), cars, viewController)
        raceController.fullRace()
        val winnerList = raceController.getFinalResult()
        viewController.printFinalResult(winnerList)
    }
}
