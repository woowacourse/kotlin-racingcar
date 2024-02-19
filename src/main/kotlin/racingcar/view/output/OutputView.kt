package racingcar.view.output

import racingcar.model.Car

interface OutputView {
    fun printExecutionResult()

    fun printProgress(middleResult: List<Car>)

    fun printLastWinner(winners: List<String>)
}
