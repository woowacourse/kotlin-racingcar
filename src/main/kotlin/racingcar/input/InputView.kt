package racingcar.input

import java.util.*

class InputView(val scanner: Scanner) {

    fun inputCarNames(): List<String> {
        println("자동차 이름을 입력하세요.")
        return readLine().split(",")
    }

    fun inputLaps(): Int {
        println("시도 횟수를 입력하세요.")
        return readLine().toInt()
    }

    private fun readLine(): String {
        return scanner.nextLine()
    }
}