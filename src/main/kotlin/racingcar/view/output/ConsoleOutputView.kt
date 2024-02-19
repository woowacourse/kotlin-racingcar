package racingcar.view.output

import racingcar.model.Car

class ConsoleOutputView : OutputView {
    override fun printExecutionResult() = println("$LINE_BREAK$EXECUTION_RESULTS")

    override fun printProgress(middleResult: List<Car>) {
        println(
            middleResult.joinToString(
                separator = MIDDLE_RESULT_SEPARATOR,
                postfix = MIDDLE_RESULT_POSTFIX
            ) { "${it.name}$MIDDLE_RESULT_FORMAT ${it.position}" })
    }

    override fun printLastWinner(winners: List<String>) = print("$LAST_WINNER ${winners.joinToString(LAST_WINNERS_SEPARATOR)}")

    companion object {
        private const val EXECUTION_RESULTS = "실행 결과"
        private const val LAST_WINNER = "최종 우승자:"
        private const val MIDDLE_RESULT_SEPARATOR = "\n"
        private const val MIDDLE_RESULT_POSTFIX = "\n"
        private const val MIDDLE_RESULT_FORMAT = ":"
        private const val LAST_WINNERS_SEPARATOR = ", "
        private const val LINE_BREAK = "\n"
    }
}
