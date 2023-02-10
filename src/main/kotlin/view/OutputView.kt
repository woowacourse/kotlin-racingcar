package view

import model.CarInfo
import util.Constants

class OutputView {

    fun outputCarNames() {
        println(Constants.INPUT_CAR_NAME)
    }

    fun outputTryNumber() {
        println(Constants.INPUT_TRY_NUMBER)
    }

    fun outputResults() {
        println()
        println(Constants.OUTPUT_RESULT)
    }

    fun outputNextLine() {
        println()
    }

    fun outputErrorMessage(error: String) {
        println(error)
    }

    fun outputResult(info: CarInfo) {
        print(info.name + " : ")
        repeat(info.position) {
            print("-")
        }
        println()
    }

    fun outputWinners(winners: List<String>) {
        println(Constants.OUTPUT_WINNER + winners.joinToString(separator = ", "))
    }
}
