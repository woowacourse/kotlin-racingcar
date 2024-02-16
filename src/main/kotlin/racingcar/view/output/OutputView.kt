package racingcar.view.output

interface OutputView {
    fun enterCarNames()

    fun enterNumberOfAttempts()

    fun printExecutionResults(
        attempts: Int,
        intermediateResults: List<String>,
    )

    fun printLastWinner(winners: List<String>)
}
