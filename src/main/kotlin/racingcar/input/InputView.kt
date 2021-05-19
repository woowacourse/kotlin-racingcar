package racingcar.input

import racingcar.domain.name.Name
import java.util.*
import kotlin.streams.toList

class InputView(private val scanner: Scanner) {

    fun inputCarNames(): List<Name> {
        println("자동차 이름을 입력하세요.")
        return readLine().split(",").stream()
            .map { Name(it.trim()) }
            .toList()
    }

    fun inputLaps(): Int {
        println("시도 횟수를 입력하세요.")
        return readLine().toInt()
    }

    private fun readLine(): String {
        return scanner.nextLine()
    }
}