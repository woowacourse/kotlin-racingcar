package racingcar.controller

import racingcar.model.Car
import racingcar.utils.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

class ViewController(
    private val inputView: InputView = InputView(Validator()),
    private val outputView: OutputView = OutputView()
) {

    fun readCarNames(): List<String> {
        outputView.printMessage(CAR_NAMES_REQUEST_MESSAGE)
        return inputView.readCarNames()
    }

    fun readRoundCount(): Int {
        outputView.printMessage(ROUND_COUNT_REQUEST_MESSAGE)
        return inputView.readRoundCount()
    }

    fun printRunResult() {
        outputView.printMessage(ROUNDS_RESULT_NOTIFICATION_MESSAGE)
    }

    fun printRoundResult(cars: List<Car>) = outputView.printRoundResult(cars)

    fun printWinners(winners: List<Car>) {
        outputView.printMessage("$WINNER_NOTIFICATION_MESSAGE: ${winners.joinToString(", ")}")
    }

    companion object {
        const val CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val ROUND_COUNT_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?"
        const val ROUNDS_RESULT_NOTIFICATION_MESSAGE = "\n실행 결과"
        const val WINNER_NOTIFICATION_MESSAGE = "최종 우승자"
    }
}
