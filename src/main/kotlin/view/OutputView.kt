package view

import message.PrintMessage

class OutputView {

    fun printCar() = println(PrintMessage.INPUT_CAR_NAMES_MESSAGE)
    fun printTryCount() = println(PrintMessage.INPUT_TRY_COUNT_MESSAGE)
    fun printRoundResult(roundResult: String) = println(roundResult)
    fun printWinner(winner: String) = println(winner)
    fun printRunResultMessage() = println("\n${PrintMessage.RUN_RESULT_MESSAGE}")
}
