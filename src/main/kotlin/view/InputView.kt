package view

import java.util.Scanner

class InputView {
    private val scanner = Scanner(System.`in`)

    fun readName(): String {
        println(INPUT_CAR_NAME_MESSAGE)
        return scanner.nextLine()
    }

    fun readTryCount(): String {
        println(INPUT_TRY_COUNT_MESSAGE)
        return scanner.nextLine()
    }

    companion object {
        const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}
