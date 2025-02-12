package controller

import model.Repository
import view.InOutView

class MainController {
    val repo = Repository()
    val inOutController = InOutController(InOutView())

    fun runProgram() {
        repo.cars = inOutController.getCarName()
        val raceController = RaceController(inOutController.getTryCount(), repo.cars, inOutController)
        raceController.fullRace()
    }
}