package racingcar.view

import java.io.BufferedReader
import java.io.InputStreamReader

object InputView {
    private val br = BufferedReader(InputStreamReader(System.`in`))

    fun inputCarNames(): List<String> {
        return br.readLine().split(SEPARATOR)
    }

    fun inputNumberOfRound(): String {
        return br.readLine()
    }

    private const val SEPARATOR = ","
}
