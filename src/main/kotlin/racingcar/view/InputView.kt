package racingcar.view

import racingcar.util.InputMessage
import java.io.BufferedReader
import java.io.InputStreamReader

object InputView {
    private val br = BufferedReader(InputStreamReader(System.`in`))
    fun inputCarNames(): List<String> {
        println(InputMessage.REGISTER_CAR_NAMES)
        return br.readLine().split(",")
    }

    fun inputNumberOfRound(): String {
        println(InputMessage.NUMBER_OF_ROUND)
        return br.readLine()
    }
}
