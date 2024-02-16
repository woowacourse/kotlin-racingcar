package racingcar.view.output

class ConsoleOutputView : OutputView {
    override fun enterCarNames() = println(ENTER_CAR_NAMES)

    override fun enterNumberOfAttempts() {
        println(ENTER_NUMBER_OF_ATTEMPTS)
    }

    override fun printExecutionResult() = println("$LINE_BREAK$EXECUTION_RESULTS")

    override fun printProgress(intermediateResults: List<String>) {
        println(intermediateResults.joinToString(separator = INTERMEDIATE_RESULT_DELIMITERS, postfix = LINE_BREAK))
    }

    override fun printLastWinner(winners: List<String>) = print("$LINE_BREAK$LAST_WINNER ${winners.joinToString(LAST_WINNERS_SEPARATOR)}")

    companion object {
        private const val ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val ENTER_NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?"
        private const val EXECUTION_RESULTS = "실행 결과"
        private const val LAST_WINNER = "최종 우승자:"
        private const val INTERMEDIATE_RESULT_DELIMITERS = "\n"
        private const val LAST_WINNERS_SEPARATOR = ", "
        private const val LINE_BREAK = "\n"
    }
}
