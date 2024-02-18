package racingcar.view

import java.io.BufferedReader
import java.io.InputStreamReader

object InputView {
    private val br = BufferedReader(InputStreamReader(System.`in`))

    fun inputCarNames(): List<String> {
        println(REGISTER_CAR_NAMES)
        return br.readLine().split(SEPARATOR)
    }

    fun inputNumberOfRound(): String {
        println(NUMBER_OF_ROUND)
        return br.readLine()
    }

    private const val SEPARATOR = ","
    private const val REGISTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val NUMBER_OF_ROUND = "시도할 횟수는 몇 회인가요?"
}
