package racingcar.view

import racingcar.constant.ERROR_WRONG_INPUT

object InputView {
    fun getCarsName(printInfo: () -> Unit): String {
        printInfo()
        return readlnOrNull()?.trim() ?: throw IllegalArgumentException(ERROR_WRONG_INPUT)
    }

    fun getRoundCount(printInfo: () -> Unit): String {
        printInfo()
        return readlnOrNull()?.trim() ?: throw IllegalArgumentException(ERROR_WRONG_INPUT)
    }
}
