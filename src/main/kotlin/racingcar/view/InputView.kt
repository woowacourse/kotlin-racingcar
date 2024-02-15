package racingcar.view

import racingcar.util.Message
import java.io.BufferedReader
import java.io.InputStreamReader

class InputView {
    fun inputCarNames(): List<String> {
        println(Message.REGISTER_CAR_NAMES)
        return br.readLine().split(INPUT_SEPARATOR)
    }

    fun inputNumberOfRound(): String {
        println(Message.NUMBER_OF_ROUND)
        return br.readLine()
    }

    companion object {
        val br = BufferedReader(InputStreamReader(System.`in`))
        const val INPUT_SEPARATOR = ","
    }
}
