package racingcar.view

import racingcar.util.Constants
import racingcar.util.Messages
import java.io.BufferedReader
import java.io.InputStreamReader

object InputView {
    private val br = BufferedReader(InputStreamReader(System.`in`))

    fun validateCarName(input: List<String>) {
        require(input.all { it.isNotEmpty() && it.length <= Constants.CONDITION_CAR_MAX_LENGTH }) {
            IllegalArgumentException(Messages.MESSAGE_INVALID_CAR_NAME)
        }
        require(input.size == input.toSet().size) {
            IllegalArgumentException(Messages.MESSAGE_DUPLICATE_CAR_NAME)
        }
    }

    fun validateCount(count: String): Int {
        require(count.toIntOrNull() != null) {
            IllegalArgumentException(Messages.MESSAGE_RACE_COUNT_NOT_INTEGER)
        }

        require(count.toInt() >= Constants.CONDITION_CAR_MIN_COUNT) {
            IllegalArgumentException(Messages.MESSAGE_RACE_COUNT_TOO_SMALL)
        }

        return count.toInt()
    }

    fun readCars(): List<String> {
        println(Messages.MESSAGE_INPUT_CAR_NAMES)
        val carsInput = br.readLine().split(Constants.DELIMITER_CAR_INPUT).map { it.trim() }
        validateCarName(carsInput)

        return carsInput
    }

    fun readCount(): Int {
        println(Messages.MESSAGE_INPUT_RACE_COUNT)
        val count = br.readLine()
        val validCount = validateCount(count)
        println()

        return validCount
    }
}
