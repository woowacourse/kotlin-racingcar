package view

import message.PrintMessage

class OutputView {

    fun printGameStart() = println(PrintMessage.INPUT_CAR_NAMES_MESSAGE)
    fun printTryCount() = println(PrintMessage.INPUT_TRY_COUNT_MESSAGE)
}
