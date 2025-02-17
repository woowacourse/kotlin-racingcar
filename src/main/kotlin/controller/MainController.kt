package controller

import model.RaceService
import view.InView
import view.OutView

class MainController {
    private val inController = InController(InView())
    private val outController = OutController(OutView())

    fun runProgram() {
        val cars = inController.getCarName()
        val raceService = RaceService(inController.getTryCount(), cars, outController)
        raceService.fullRace()
        val winnerList = raceService.getFinalResult()
        outController.printFinalResult(winnerList)
    }
}
