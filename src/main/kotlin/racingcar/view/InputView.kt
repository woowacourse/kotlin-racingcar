package racingcar.view

import racingcar.util.Message
import java.io.BufferedReader
import java.io.InputStreamReader

class InputView {
    fun inputCarNames(): List<String> {
        println(Message.REGISTER_CAR_NAMES)
        return br.readLine().split(",")
    }

    companion object {
        val br = BufferedReader(InputStreamReader(System.`in`))
    }
}
