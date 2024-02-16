package racingcar.view.output

interface OutputView {
    fun enterCarNames()

    fun enterNumberOfAttempts()

    fun printExecutionResult()

    fun printProgress(intermediateResults: List<String>)

    fun printLastWinner(winners: List<String>)
}
