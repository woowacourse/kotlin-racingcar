package racingcar.view

import racingcar.constant.ERROR_INPUT_HANDLER
import racingcar.constant.ERROR_NAME_LENGTH
import racingcar.constant.ERROR_WRONG_NUMBER
import racingcar.domain.Validator
import kotlin.reflect.KFunction1

object InputView {
    fun getCarsName(printInfo: () -> Unit): List<String> {
        return runCatching {
            printInfo()
            getVerifiedCarsName()
        }.getOrElse { error ->
            inputErrorHandler(error, ::getCarsName, printInfo) as List<String>
        }
    }

    private fun getVerifiedCarsName(): List<String> {
        val input = readLine()?.trim()
        val names: List<String>

        if (!input.isNullOrBlank()) {
            names = input.split(",").map { it.trim() }
            checkNameLength(names)
        } else {
            throw IllegalArgumentException(ERROR_NAME_LENGTH)
        }

        return names
    }

    fun checkNameLength(value: List<String>) {
        value.forEach {
            require(Validator.isNameLengthInRange(it)) { ERROR_NAME_LENGTH }
        }
    }

    fun getRoundCount(printInfo: () -> Unit): Int {
        return runCatching {
            printInfo()
            getVerifiedRoundCount()
        }.getOrElse { error ->
            inputErrorHandler(error, ::getRoundCount, printInfo) as Int
        }
    }

    private fun getVerifiedRoundCount(): Int {
        val input = readLine()?.trim()

        if (!input.isNullOrBlank()) {
            require(Validator.isNumber(input)) { ERROR_WRONG_NUMBER }
        } else {
            throw IllegalArgumentException(ERROR_WRONG_NUMBER)
        }

        return input.toInt()
    }

    private fun inputErrorHandler(
        error: Throwable,
        repeatFunction: KFunction1<() -> Unit, Any>,
        printInfo: () -> Unit,
    ): Any {
        return when (error) {
            is IllegalArgumentException -> inputIllegalArgumentExceptionHandler(error, repeatFunction, printInfo)
            else -> throw IllegalStateException(ERROR_INPUT_HANDLER)
        }
    }

    private fun inputIllegalArgumentExceptionHandler(
        error: Throwable,
        repeatFunction: KFunction1<() -> Unit, Any>,
        printInfo: () -> Unit,
    ): Any {
        println(error.message)
        return repeatFunction(printInfo)
    }
}
