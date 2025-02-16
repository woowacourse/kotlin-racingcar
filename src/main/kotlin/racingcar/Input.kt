package racingcar

class Input {
    fun readCars(): List<Car> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val userInput: String? = readlnOrNull()
        requireNotNull(userInput) { "자동차의 이름을 입력해주세요" }
        if (checkCarNameValid(userInput)) {
            return userInput.toCars()
        }
        println("자동차 이름은 5자를 초과할 수 없습니다. 다시 입력해주세요.")
        return readCars()
    }

    fun readRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val userInput: String? = readlnOrNull()
        requireNotNull(userInput) { "시도 횟수를 입력해주세요." }
        if (checkRoundValid(userInput) != 0) {
            return userInput.toInt()
        }
        println("올바른 숫자를 입력하세요.")
        return readRound()
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
