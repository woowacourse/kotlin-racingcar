package view

import java.util.Scanner

class InputView {
    private val scanner = Scanner(System.`in`)

    fun readCars(): String {
        println(INPUT_CAR_NAME)
        return scanner.nextLine()
    }

    fun readAttempt(): Int {
        println(INPUT_ATTEMPTS)
        val attempts = scanner.nextLine()
        return requireNotNull(attempts.toIntOrNull()) { ATTEMPT_INPUT_ERROR }
    }

    companion object {
        const val INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val INPUT_ATTEMPTS = "시도할 횟수는 몇 회인가요?"
        const val ATTEMPT_INPUT_ERROR = "[ERROR]: 시도 횟수를 입력해주세요."
    }
}
