package view

interface OutputViewInterface {
    fun printCar()
    fun printTryCount()
    fun printRoundResult(roundResult: String)
    fun printWinner(winners: List<String>)

    fun printRunResultMessage()
    fun printErrorMessage(error: String)
}
