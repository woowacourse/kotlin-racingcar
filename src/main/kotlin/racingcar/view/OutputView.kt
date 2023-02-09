package racingcar.view

import racingcar.resources.OUTPUT_RESULT
import racingcar.resources.OUTPUT_WINNER

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
        println(OUTPUT_RESULT)
    }

    fun printWinner(carNames: List<String>) {
        print(OUTPUT_WINNER + carNames.joinToString(", "))
    }
}
