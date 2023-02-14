package view

class OutputView : OutputViewInterface {
    override fun printRoundResult(roundResult: String) = println(roundResult)
    override fun printWinner(winners: List<String>) {
        var output = "최종 우승자: "
        winners.forEach { name ->
            output += "$name, "
        }
        println(output.substring(0, output.length - 2))
    }

    override fun printRunResultMessage() = println("\n$RUN_RESULT_MESSAGE")
    override fun printErrorMessage(error: String?) = println(error)

    companion object {
        const val RUN_RESULT_MESSAGE = "실행 결과"
    }
}
