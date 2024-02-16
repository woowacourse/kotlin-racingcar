package racingcar.view

class OutputView {
    fun enterCarNames() = println(ENTER_CAR_NAMES)

    fun enterNumberOfAttempts() {
        println(ENTER_NUMBER_OF_ATTEMPTS)
    }

    fun printExecutionResults(
        attempts: Int,
        intermediateResults: List<String>,
    ) {
        println("$LINE_BREAK$EXECUTION_RESULTS")
        repeat(attempts) {
            println(intermediateResults.joinToString(separator = INTERMEDIATE_RESULT_DELIMITERS, postfix = LINE_BREAK))
        }
    }

    fun printLastWinner(winners: List<String>) = print("$LINE_BREAK$LAST_WINNER ${winners.joinToString(LAST_WINNERS_SEPARATOR)}")

    companion object {
        const val ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val ENTER_NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?"
        const val EXECUTION_RESULTS = "실행 결과"
        const val LAST_WINNER = "최종 우승자:"
        const val INTERMEDIATE_RESULT_DELIMITERS = "\n"
        const val LAST_WINNERS_SEPARATOR = ", "
        const val LINE_BREAK = "\n"
    }
}
