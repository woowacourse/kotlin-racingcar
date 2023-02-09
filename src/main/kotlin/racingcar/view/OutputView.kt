package racingcar.view

import racingcar.resources.OUTPUT_RESULT_MESSAGE
import racingcar.resources.OUTPUT_WINNER_MESSAGE

class OutputView {
    fun printCarsState(carNames: List<String>, carLocations: List<Int>) {
        val carStates = carNames.zip(carLocations)
        carStates.forEach { (carName, carLocation) ->
            printCarState(carName, carLocation)
        }
        println()
    }

    private fun printCarState(carName: String, carLocation: Int) {
        println(carName + " : " + "-".repeat(carLocation))
    }

    fun printResult() {
        println(OUTPUT_RESULT_MESSAGE)
    }

    fun printWinner(carNames: List<String>) {
        print(OUTPUT_WINNER_MESSAGE + carNames.joinToString(", "))
    }
}
