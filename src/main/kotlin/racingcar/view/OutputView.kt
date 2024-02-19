package racingcar.view

import racingcar.constants.Constants.CURRENT_POSITION_TEMPLATE
import racingcar.constants.Constants.FINAL_WINNERS
import racingcar.constants.Constants.INPUT_CAR_NAMES_MESSAGE
import racingcar.constants.Constants.INPUT_TRIAL_NUM_MESSAGE
import racingcar.constants.Constants.PROGRESS_BAR
import racingcar.constants.Constants.TRIAL_RESULT_MESSAGE
import racingcar.constants.Constants.WINNERS_SEPARATOR

object OutputView {
    fun printInputCarNamesMessage() = println(INPUT_CAR_NAMES_MESSAGE)

    fun printInputTrialNumMessage() = println(INPUT_TRIAL_NUM_MESSAGE)

    fun printTrialResultMessage() = println(TRIAL_RESULT_MESSAGE)

    fun printCurrentPosition(
        name: String,
        position: Int,
    ) = println(CURRENT_POSITION_TEMPLATE.format(name, PROGRESS_BAR.repeat(position)))

    fun printFinalWinners(names: List<String>) = println(FINAL_WINNERS.format(names.joinToString(WINNERS_SEPARATOR)))

    fun printEmptyLine() = println()
}
