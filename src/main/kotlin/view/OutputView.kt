package view

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

    fun outputResult(info: Pair<String, Int>) {
        print(info.first + " : ")
        for (i in 1..info.second) {
            print("-")
        }
        println()
    }

    fun outputWinners(winners: List<String>) {
        println(Constants.OUTPUT_WINNER + winners.joinToString(separator = ", "))
    }
}
