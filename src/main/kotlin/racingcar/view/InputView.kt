package racingcar.view

import racingcar.domain.Car
import racingcar.toCars

class InputView {
    fun readCars(): List<Car>? {
        val userInput: String? = readlnOrNull()
        requireNotNull(userInput) { "자동차의 이름을 입력해주세요" }
        if (checkCarNameValid(userInput)) {
            return userInput.toCars()
        }
        return null
    }

    fun readRound(): Int? {
        val userInput: String? = readlnOrNull()
        requireNotNull(userInput) { "시도 횟수를 입력해주세요." }
        if (checkRoundValid(userInput) != 0) {
            return userInput.toInt()
        }
        return null
    }

    fun checkCarNameValid(name: String): Boolean {
        runCatching {
            require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH)
        }.onSuccess { return true }
        return false
    }

    fun checkRoundValid(userInput: String): Int {
        val validatedNumber = userInput.toIntOrNull() ?: 0
        if (validatedNumber <= 0) return 0
        return validatedNumber
    }

    companion object {
        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5
    }
}
