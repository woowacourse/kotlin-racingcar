package controller

import view.InputView
import view.OutputView

class ProgramController {
    private val viewController = ViewController(InputView(), OutputView())

    fun runProgram() {
        val cars = viewController.getCarName()
        val raceController = RaceController(viewController.getTryCount(), cars, viewController)
        raceController.startRacing()
        val winnerList = raceController.getFinalResult()
        viewController.printFinalResult(winnerList)
    }
}
