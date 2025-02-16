package controller

import model.Car
import view.InView
import view.OutView

class OutController(private var outView: OutView) {
    fun printCurrentPosition(cars: MutableList<Car>) {
        cars.forEach { car ->
            outView.printCurrentResult(car)
        }
        println()
    }

    fun printGameResult() {
        outView.printGameResult()
    }

    fun printFinalResult(winnerResult: MutableList<Car>) {
        outView.printFinalResult(winnerResult)
    }
}
