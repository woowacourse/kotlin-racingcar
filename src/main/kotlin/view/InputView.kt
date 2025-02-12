package view

import util.Constants
import util.Messages
import java.io.BufferedReader
import java.io.InputStreamReader

object InputView {
    private val br = BufferedReader(InputStreamReader(System.`in`))

    fun readCars(): List<String> {
        println(Messages.MESSAGE_INPUT_CAR_NAMES)
        val carsInput = br.readLine().split(Constants.DELIMITER_CAR_INPUT).map { it.trim() }
        carsInput.forEach {
            if (it.isEmpty() || it.length > Constants.CONDITION_CAR_MAX_LENGTH) {
                throw IllegalArgumentException()
            }
        }

        if (carsInput.size > carsInput.toSet().size) {
            throw IllegalArgumentException()
        }

        return carsInput
    }

    fun readCount(): Int {
        println(Messages.MESSAGE_INPUT_RACE_COUNT)
        val count = br.readLine().toIntOrNull() ?: throw IllegalArgumentException()
        if (count < Constants.CONDITION_CAR_MIN_COUNT) throw IllegalArgumentException()
        println()
        return count
    }
}