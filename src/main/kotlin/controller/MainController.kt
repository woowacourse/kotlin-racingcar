package controller

import view.InView
import view.OutView

class MainController {
    private val inController = InController(InView())
    private val outController = OutController(OutView())

    fun runProgram() {
        val cars = inController.getCarName()
        val raceController = RaceController(inController.getTryCount(), cars, outController)
        raceController.fullRace()
        val winnerList = raceController.getFinalResult()
        outController.printFinalResult(winnerList)
    }
}
