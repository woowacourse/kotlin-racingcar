package view

import constant.RacingGameOutputConstant
import domain.Car

class OutputView {
    fun printCurrentResult(currentResult: String) {
        println(currentResult)
    }

    fun printGameResult() {
        println(RacingGameOutputConstant.GAME_RESULT)
    }

    fun printFinalResult(winnerList: List<Car>) {
        print(RacingGameOutputConstant.FINAL_RESULT)
        println(winnerList.joinToString(", ") { it.name })
    }
}
