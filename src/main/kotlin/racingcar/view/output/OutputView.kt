package racingcar.view.output

import racingcar.constants.OutputConstants
import racingcar.model.Car

class OutputView {
    fun printInputCarNamesMessage() {
        println(OutputConstants.INPUT_CAR_NAMES_MESSAGE)
    }

    fun printInputTryCountMessage() {
        println(OutputConstants.INPUT_TRY_COUNT_MESSAGE)
    }

    fun printProcessStepMessage() {
        lineBreak()
        println(OutputConstants.PROCESS_STEP_MESSAGE)
    }

    fun printProcessStep(cars: List<Car>) {
        cars.forEach { car ->
            println(car.getStepState())
        }
        lineBreak()
    }

    fun printWinners(winners: List<Car>) {
        print(OutputConstants.WINNERS_MESSAGE + winners.joinToString(OutputConstants.WINNERS_DELIMITER))
    }

    private fun lineBreak() = println()
}
