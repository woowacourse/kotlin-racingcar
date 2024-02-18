package racingcar.view.output

import racingcar.constants.StringConstants
import racingcar.model.Car

object OutputView {
    fun printInputCarNamesMessage() = println(StringConstants.INPUT_CAR_NAMES_MESSAGE)

    fun printInputTryCountMessage() = println(StringConstants.INPUT_TRY_COUNT_MESSAGE)

    fun printProcessResultMessage() {
        lineBreak()
        println(StringConstants.PROCESS_RESULT_MESSAGE)
    }

    fun printCarsPosition(cars: List<Car>) {
        cars.forEach { car ->
            printCarPosition(car)
        }
        lineBreak()
    }

    private fun printCarPosition(car: Car) = println("$car : ${StringConstants.CAR_POSITION.repeat(car.position)}")

    fun printWinners(winners: List<Car>) =
        print("${StringConstants.WINNERS_MESSAGE}${winners.joinToString(StringConstants.WINNERS_DELIMITER)}")

    private fun lineBreak() = println()
}
