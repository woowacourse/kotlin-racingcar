package view

import constant.InOutConstants
import model.Car

class OutView {
    fun printCurrentResult(car: Car) {
        println(InOutConstants.CURRENT_RESULT_FORMAT.format(car.name, "-".repeat(car.currentPosition)))
    }

    fun printGameResult() {
        println(InOutConstants.GAME_RESULT)
    }

    fun printFinalResult(winnerList: List<Car>) {
        print(InOutConstants.FINAL_RESULT)
        println(winnerList.joinToString(", ") { it.name })
    }

}
