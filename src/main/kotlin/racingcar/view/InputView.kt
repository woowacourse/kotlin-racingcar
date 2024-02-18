package racingcar.view


class InputView {
    fun printExecutionResults() = println(EXECUTION_RESULTS)
    fun printLastWinner() = print(LAST_WINNER)
    fun askCarNames(): List<String> {
        println(ENTER_CAR_NAMES)
        val carNames = readln()
        val carNamesList = carNames.split(",").map { it.trim() }

        require(Regex("^[a-zA-Z가-힣,]+\$").matches(carNames))
        require(carNamesList.size == carNamesList.toSet().size)
        require(carNamesList.size in 1..100)

        return carNamesList
    }

    fun askNumberOfAttempts(): Int {
        println(ENTER_NUMBER_OF_ATTEMPTS)
        val numberOfAttempts = readln().toInt()

        require(numberOfAttempts in 1..10000)

        return numberOfAttempts
    }

    companion object {
        const val ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val ENTER_NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?"
        const val EXECUTION_RESULTS = "실행 결과"
        const val LAST_WINNER = "최종 우승자: "
    }
}
