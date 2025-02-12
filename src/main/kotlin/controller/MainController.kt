package controller

import model.Repository
import view.InOutView
import java.util.Random

class MainController {
    private val inOutController = InOutController(InOutView())

    fun runProgram() {
        val repo = Repository(inOutController.getCarName(),Random())
        val raceController = RaceController(inOutController.getTryCount(), repo, inOutController)
        raceController.fullRace()
        val winnerList = raceController.getFinalResult()
        inOutController.printFinalResult(winnerList)
    }
}