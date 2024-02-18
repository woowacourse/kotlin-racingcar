package racingcar.view


class InputView {
    fun printExecutionResults() = println(EXECUTION_RESULTS)
    fun printLastWinner() = print(LAST_WINNER)
    fun askCarNames(): List<String> {
        println(ENTER_CAR_NAMES)
        val carNames = readln()
        val carNamesList = carNames.split(",").map { it.trim() }

        require(Regex(NAME_FORMAT).matches(carNames))
        require(carNamesList.size == carNamesList.toSet().size)
        require(carNamesList.size in numberOfCarsRange)

        return carNamesList
    }

    fun askNumberOfAttempts(): Int {
        println(ENTER_NUMBER_OF_ATTEMPTS)
        val numberOfAttempts = readln().toInt()

        require(numberOfAttempts in numberOfAttemptsRange)

        return numberOfAttempts
    }

    companion object {
        const val ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val ENTER_NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?"
        const val EXECUTION_RESULTS = "실행 결과"
        const val LAST_WINNER = "최종 우승자: "

        const val NAME_FORMAT = "^[a-zA-Z가-힣,]+\$"
        val numberOfCarsRange = 1..100
        val numberOfAttemptsRange = 1..10000
    }
}
