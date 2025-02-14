package controller

import view.InOutView

class MainController {
    private val inController = InController(InOutView())
    private val outController = OutController(InOutView())

    fun runProgram() {
        val cars = inController.getCarName()
        val raceController = RaceController(inController.getTryCount(), cars, outController)
        raceController.fullRace()
        val winnerList = raceController.getFinalResult()
        outController.printFinalResult(winnerList)
    }
}
