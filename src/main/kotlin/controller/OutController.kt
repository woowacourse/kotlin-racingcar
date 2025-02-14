package controller

import model.Car
import view.InOutView

class OutController(var inOutView: InOutView) {
    fun printCurrentPosition(cars: MutableList<Car>) {
        cars.forEach { car ->
            inOutView.printCurrentResult(car)
        }
        println()
    }

    fun printGameResult() {
        inOutView.printGameResult()
    }

    fun printFinalResult(winnerResult: MutableList<Car>) {
        inOutView.printFinalResult(winnerResult)
    }
}
