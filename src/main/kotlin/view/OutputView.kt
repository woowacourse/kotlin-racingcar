package view

import constant.MessageConstant
import model.Car

class OutputView {
    fun printCurrentResult(currentResult: String) {
        println(currentResult)
    }

    fun printGameResult() {
        println(MessageConstant.GAME_RESULT)
    }

    fun printFinalResult(winnerList: List<Car>) {
        print(MessageConstant.FINAL_RESULT)
        println(winnerList.joinToString(", ") { it.name })
    }
}
