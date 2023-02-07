package racingcar.view

import racingcar.resources.ERROR_INPUT_NAME_AT_MOST_FIVE
import racingcar.resources.INPUT_CAR_NAMES

class InputView {
    fun inputCarNames(): List<String> {
        println(INPUT_CAR_NAMES)
        val userInput = readLine()?.split(',')?.map { checkCarNameLength(it) }
        return userInput ?: listOf("")
    }

    private fun checkCarNameLength(carName: String): String {
        require(carName.length in 1..5) { println(ERROR_INPUT_NAME_AT_MOST_FIVE) }
        return carName
    }

    fun inputRacingCount(): Int {
        return readLine()?.toIntOrNull() ?: 0
    }
}
