package racingcar.view

import racingcar.utils.InputValidator

object InputView {

    private val reader = System.`in`.bufferedReader()

    fun readNames(): List<String> = try {
        val input = reader.readLine()
        InputValidator.getValidatedNames(input)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        readNames()
    }

    fun readTrialNum(): Int = try {
        val input = reader.readLine()
        InputValidator.getValidatedTrialNum(input)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        readTrialNum()
    }
}