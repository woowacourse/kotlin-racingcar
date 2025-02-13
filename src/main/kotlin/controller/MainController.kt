package controller

import view.InOutView

class MainController {
    private val inOutController = InOutController(InOutView())

    fun runProgram() {
        val cars = inOutController.getCarName()
        val raceController = RaceController(inOutController.getTryCount(), cars, inOutController)
        raceController.fullRace()
        val winnerList = raceController.getFinalResult()
        inOutController.printFinalResult(winnerList)
    }
}
