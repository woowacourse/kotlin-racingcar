package racingcar.view

import racingcar.entity.Car
import racingcar.entity.Position

object OutputView {
    private const val MSG_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val MSG_INPUT_ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?"
    private const val MSG_STEP_RESULT = "실행 결과"
    private const val MSG_WINNER = "최종 우승자: "

    fun requestCarName() {
        println(MSG_INPUT_CAR_NAME)
    }

    fun requestAttemptCount() {
        println(MSG_INPUT_ATTEMPT_COUNT)
    }

    fun printStepResult() {
        println(MSG_STEP_RESULT)
    }

    fun printWinners() {
        print(MSG_WINNER)
    }

    fun stepResult(result: String) {
        println(result)
        println()
    }

    fun makeLogs(cars: List<Car>): String {
        return cars.joinToString("\n") { it.name.toString() + " : " + makePositionLog(it.getPosition()) }
    }

    private fun makePositionLog(position: Position): String {
        return "-".repeat(position.toInt())
    }

    fun winner(winners: List<Car>) {
        println(winners.joinToString(", ") { it.name.toString() })
    }
}
