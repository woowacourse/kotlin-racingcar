package racingcar.controller

import racingcar.domain.Car
import racingcar.view.OutputView

class OutputController(
    private val outputView: OutputView = OutputView()
) {
    fun printRunResult() {
        outputView.printMessage(ROUNDS_RESULT_NOTIFICATION_MESSAGE)
    }

    fun printRoundResult(cars: List<Car>) = outputView.printRoundResult(cars)

    fun printWinners(winners: List<Car>) {
        outputView.printMessage("$WINNER_NOTIFICATION_MESSAGE: ${winners.joinToString(", ")}")
    }

    companion object {
        private const val ROUNDS_RESULT_NOTIFICATION_MESSAGE = "\n실행 결과"
        private const val WINNER_NOTIFICATION_MESSAGE = "최종 우승자"
    }
}
