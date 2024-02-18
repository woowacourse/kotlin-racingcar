package racingcar.view.output

import racingcar.constants.OutputConstants
import racingcar.model.Car

object OutputView {
    fun printInputCarNamesMessage() = println(OutputConstants.INPUT_CAR_NAMES_MESSAGE)

    fun printInputTryCountMessage() = println(OutputConstants.INPUT_TRY_COUNT_MESSAGE)

    fun printProcessResultMessage() {
        lineBreak()
        println(OutputConstants.PROCESS_RESULT_MESSAGE)
    }

    fun printCarsPosition(cars: List<Car>) {
        cars.forEach { car ->
            printCarPosition(car)
        }
        lineBreak()
    }

    private fun printCarPosition(car: Car) = println("$car : ${OutputConstants.CAR_POSITION.repeat(car.position)}")

    fun printWinners(winners: List<Car>) =
        print("${OutputConstants.WINNERS_MESSAGE} ${winners.joinToString(OutputConstants.WINNERS_DELIMITER)}")

    private fun lineBreak() = println()
}
