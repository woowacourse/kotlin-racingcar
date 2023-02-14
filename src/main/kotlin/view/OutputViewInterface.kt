package view

interface OutputViewInterface {
    fun printRoundResult(roundResult: String)
    fun printWinner(winners: List<String>)

    fun printRunResultMessage()
    fun printErrorMessage(error: String?)
}
