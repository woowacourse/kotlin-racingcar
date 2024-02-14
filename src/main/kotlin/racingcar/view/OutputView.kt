package racingcar.view

import racingcar.model.Messages

class OutputView {
    fun printEnterCarNames() = println(Messages.ENTER_CAR_NAMES)
    fun enterNumberOfAttempts() = println(Messages.ENTER_NUMBER_OF_ATTEMPTS)
    fun printExecutionResults() = println(Messages.EXECUTION_RESULTS)
    fun printLastWinner() = print(Messages.LAST_WINNER)
}