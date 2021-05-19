package racingcar.input

import java.util.*

class InputView(val scanner: Scanner) {
    fun inputCarNames(): String {
        println("자동차 이름을 입력하세요.")
        return readLine()
    }

    fun readLine(): String {
        return scanner.nextLine()
    }
}