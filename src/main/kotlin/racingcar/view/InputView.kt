package racingcar.view

import racingcar.util.Message
import java.io.BufferedReader
import java.io.InputStreamReader

object InputView {
    private val br = BufferedReader(InputStreamReader(System.`in`))
    fun inputCarNames(): List<String> {
        println(Message.REGISTER_CAR_NAMES)
        return br.readLine().split(",")
    }

    fun inputNumberOfRound(): String {
        println(Message.NUMBER_OF_ROUND)
        return br.readLine()
    }
}
