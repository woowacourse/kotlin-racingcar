package controller

import model.Repository
import view.InOutView

class MainController {
    val inOutController = InOutController(InOutView())

    fun runProgram() {
        val repo = Repository(inOutController.getCarName())
        val raceController = RaceController(inOutController.getTryCount(), repo, inOutController)
        raceController.fullRace()
        val winnerList = raceController.getFinalResult()
        inOutController.printFinalResult(winnerList)
    }
}