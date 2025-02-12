package view

import constant.InOutConstant
import data.Car

class InOutView {
    fun getCarNames(): String {
        println(InOutConstant.INPUT_CAR_NAME)
        return readln()
    }

    fun getTryCount(): String {
        println(InOutConstant.INPUT_TRY_COUNT)
        return readln()
    }

    fun printCurrentResult(car: Car) {
        println(InOutConstant.OUTPUT_CURRENT_RESULT_FORMAT.format(car.name, "-".repeat(car.currentPosition)))
    }

    fun printGameResult() {
        println(InOutConstant.OUTPUT_GAME_RESULT)
    }
}