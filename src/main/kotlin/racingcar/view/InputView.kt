package racingcar.view

import java.lang.NumberFormatException

object InputView {

    fun inputCarNames() : List<String> {
        println("자동차 이름을 입력해주세요. 이름은 쉼표로 구분해주세요.")
        return readLine()!!.split(",")
    }

    fun inputRound(): Int {
        try {
            println("진행할 횟수를 입력해주세요.")
            return readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            return inputRound()
        }
    }
}
