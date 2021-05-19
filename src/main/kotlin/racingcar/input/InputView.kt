package racingcar.input

import java.util.*

class InputView(val scanner: Scanner) {


    fun inputCarNames(): List<String> {
        println("자동차 이름을 입력하세요.")
        return readLine().split(",")
    }

    fun readLine(): String {
        return scanner.nextLine()
    }
}