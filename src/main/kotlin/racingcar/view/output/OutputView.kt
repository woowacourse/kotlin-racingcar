package racingcar.view.output

import racingcar.model.Car

interface OutputView {
    fun printExecutionResult()

    fun printProgress(cars: List<Car>)

    fun printLastWinner(winners: List<String>)
}
