package racingcar

class Input {
    fun readCars(): List<Car> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val userInput: String? = readlnOrNull()
        requireNotNull(userInput) { "자동차의 이름을 입력해주세요" }
        return userInput.toCars()
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

    fun checkRoundValid(userInput: String): Int {
        val validatedNumber = userInput.toIntOrNull() ?: 0
        if (validatedNumber <= 0) return 0
        return validatedNumber
    }
}
