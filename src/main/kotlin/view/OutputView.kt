package view

import constant.MessageConstant
import model.Car

class OutputView {
    fun printCurrentResult(car: Car) {
        println(MessageConstant.ROUND_RESULT_FORMAT.format(car.name, "-".repeat(car.currentPosition)))
    }

    fun printGameResult() {
        println(MessageConstant.GAME_RESULT)
    }

    fun printFinalResult(winnerList: MutableList<Car>) {
        print(MessageConstant.FINAL_RESULT)
        println(winnerList.joinToString(", ") { it.name })
    }
}
