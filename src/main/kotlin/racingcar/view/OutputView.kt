package racingcar.view

class OutputView {
    fun printExecutionResults() = println(InputView.EXECUTION_RESULTS)
    fun printFinalWinners(finalWinners: List<String>){
        print(InputView.LAST_WINNER)
        print(finalWinners.joinToString(FINAL_WINNER_PRINT_SEPARATOR))
    }

    companion object{
        const val FINAL_WINNER_PRINT_SEPARATOR = ","
    }
}
