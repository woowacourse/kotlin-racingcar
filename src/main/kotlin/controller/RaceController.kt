package controller

import data.Car
import model.Repository

class RaceController(val count: Int, val repo: Repository, val inOutController: InOutController) {
    fun fullRace() {
        inOutController.printGameResult()
        repeat(count) {
            oneRace()
        }
    }

    private fun oneRace() {
        for (car in repo.getCars()) {
            repo.moveCar(car)
        }
        inOutController.printCurrentPosition(repo.getCars())
    }

    fun getFinalResult(): MutableList<Car> {
        return repo.comparePosition()
    }
}