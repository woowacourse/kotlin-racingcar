package racingcar.view

import racingcar.constants.Constants.CURRENT_POSITION_TEMPLATE
import racingcar.constants.Constants.FINAL_WINNERS
import racingcar.constants.Constants.INPUT_CAR_NAMES_MESSAGE
import racingcar.constants.Constants.INPUT_TRIAL_NUM_MESSAGE
import racingcar.constants.Constants.PROGRESS_BAR
import racingcar.constants.Constants.TRIAL_RESULT_MESSAGE
import racingcar.constants.Constants.WINNERS_SEPARATOR
import racingcar.model.Car

object OutputView {

    fun printNewLine() = println()

    fun printInputCarNamesMessage() = println(INPUT_CAR_NAMES_MESSAGE)

    fun printInputTrialNumMessage() = println(INPUT_TRIAL_NUM_MESSAGE)

    fun printTrialResultMessage() = println(TRIAL_RESULT_MESSAGE)

    fun printNameAndCurrentPosition(cars: List<Car>) {
        cars.forEach { car -> println(CURRENT_POSITION_TEMPLATE.format(car.name, PROGRESS_BAR.repeat(car.position))) }
        println()
    }

    fun printFinalWinners(names: List<String>) = println(FINAL_WINNERS.format(names.joinToString(WINNERS_SEPARATOR)))
}
