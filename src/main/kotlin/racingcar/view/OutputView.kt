package racingcar.view

import racingcar.entity.Car

class OutputView {
    fun printLnMessage(message: String) {
        println(message)
    }

    fun printMessage(message: String) {
        print(message)
    }

    fun stepResult(result: String) {
        println(result)
        println()
    }

    fun winner(winners: List<Car>) {
        println(winners.joinToString(", ") { it.getName().toString() })
    }

    companion object {
        const val MSG_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val MSG_INPUT_ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?"
        const val MSG_STEP_RESULT = "실행 결과"
        const val MSG_WINNER = "최종 우승자: "
    }
}
