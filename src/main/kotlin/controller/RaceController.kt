package controller

import data.Car
import java.util.Random

class RaceController(val count: Int, val cars: MutableList<Car>, val inOutController: InOutController) {
    fun fullRace() {
        inOutController.printGameResult()
        repeat(count) {
            oneRace()
        }
    }

    private fun oneRace() {
        for (car in cars) {
            car.currentPosition += goOrNot()
        }
        inOutController.printCurrentPosition(cars)
    }

    private fun goOrNot(): Int {
        var nowNumber = Random().nextInt(10)

        if (nowNumber >= 4) return 1
        return 0
    }
}