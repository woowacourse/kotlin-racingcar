package racingcar.view

import racingcar.entity.Car
import racingcar.entity.Position

object OutputView {
    const val MSG_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    const val MSG_INPUT_ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?"
    const val MSG_STEP_RESULT = "실행 결과"
    const val MSG_WINNER = "최종 우승자: "

    fun printLnMessage(message: String) {
        println(message)
    }

    fun attemptHistory(result: List<List<Car>>) {
        println(MSG_STEP_RESULT)
        val attempts = result.map { formatAttempt(it) }
        attempts.forEach { println(it) }
    }

    private fun formatAttempt(car: List<Car>): String =
        car.joinToString("\n", "", "\n") { "${it.name.value} : ${formatPosition(it.position)}" }

    private fun formatPosition(position: Position): String = "-".repeat(position.value)

    fun winner(winners: List<Car>) {
        print(MSG_WINNER)
        println(winners.joinToString(", ") { it.name.value })
    }
}
