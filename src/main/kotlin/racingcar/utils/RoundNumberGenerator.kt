package racingcar.utils

import racingcar.ui.getRoundByUser
import racingcar.ui.printErrorMessage
import racingcar.validator.validateRoundNumber

fun getRoundInput(): Int {
    val userInput = getRoundByUser()
    return try {
        validateRoundNumber(userInput)
        Integer.parseInt(userInput)
    } catch (e: IllegalArgumentException) {
        printErrorMessage(e.message)
        return getRoundInput()
    }
}
