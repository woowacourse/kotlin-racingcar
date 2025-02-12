package view

import util.Constants
import util.Messages
import util.Validator
import java.io.BufferedReader
import java.io.InputStreamReader

object InputView {
    private val br = BufferedReader(InputStreamReader(System.`in`))

    fun readCars(): List<String> {
        println(Messages.MESSAGE_INPUT_CAR_NAMES)
        val carsInput = br.readLine().split(Constants.DELIMITER_CAR_INPUT).map { it.trim() }
        Validator.validateCarName(carsInput)

        return carsInput
    }

    fun readCount(): Int {
        println(Messages.MESSAGE_INPUT_RACE_COUNT)
        val count = br.readLine()
        Validator.validateCount(count)
        println()

        return count.toInt()
    }
}
