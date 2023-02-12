package racingcar.view

import racingcar.constant.ERROR_NAME_LENGTH
import racingcar.constant.ERROR_NULL_OR_BLANK
import racingcar.constant.ERROR_WRONG_NUMBER
import racingcar.domain.InputValueValidator

class InputView {
    fun getCarsName(printInfo: () -> Unit): List<String> {
        return try {
            printInfo()
            getVerifiedCarsName()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getCarsName(printInfo)
        }
    }

    private fun getVerifiedCarsName(): List<String> {
        val input = getNotNullValue()
        val names: List<String> = input.split(",").map { it.trim() }
        checkNameLength(names)
        return names
    }

    fun checkNameLength(value: List<String>) {
        value.forEach {
            require(it.isNotBlank()) { ERROR_NULL_OR_BLANK }
            require(InputValueValidator.isNameLengthInRange(it)) { ERROR_NAME_LENGTH }
        }
    }

    fun getRoundCount(printInfo: () -> Unit): Int {
        return try {
            printInfo()
            getVerifiedRoundCount()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getRoundCount(printInfo)
        }
    }

    private fun getVerifiedRoundCount(): Int {
        val input = getNotNullValue()
        require(InputValueValidator.isNumber(input)) { ERROR_WRONG_NUMBER }
        return input.toInt()
    }

    private fun getNotNullValue(): String {
        val input = readLine()?.trim()
        require(!input.isNullOrBlank()) { ERROR_NULL_OR_BLANK }
        return input
    }
}
