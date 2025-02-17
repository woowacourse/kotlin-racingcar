package view

import constant.InOutConstants
import model.Car

class OutView {
    fun printCurrentResult(race: List<Car>) {
        race.forEach { car ->
            println(InOutConstants.CURRENT_RESULT_FORMAT.format(car.name, "-".repeat(car.currentPosition)))
        }
        println()
    }

    fun printGameResult() {
        println(InOutConstants.GAME_RESULT)
    }

    fun printFinalResult(winnerList: List<Car>) {
        print(InOutConstants.FINAL_RESULT)
        print(winnerList.joinToString(", ") { it.name })
    }
}
