package racingcar.view

import racingcar.resources.OUTPUT_RESULT_MESSAGE
import racingcar.resources.OUTPUT_WINNER_MESSAGE

class OutputView {
    fun printCarsState(carNames: List<String>, carLocations: List<Int>) {
        carNames.forEachIndexed { index, carName ->
            printCarState(carName, carLocations[index])
        }
        println()
    }

    private fun printCarState(carName: String, carLocation: Int) {
        print("$carName : ")
        println("-".repeat(carLocation))
    }

    fun printResult() {
        println(OUTPUT_RESULT_MESSAGE)
    }

    fun printWinner(cars: List<String>) {
        print(OUTPUT_WINNER_MESSAGE + cars.joinToString(", ") { it })
    }
}
