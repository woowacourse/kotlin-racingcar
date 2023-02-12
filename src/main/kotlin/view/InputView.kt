package view

import common.ERROR_MESSAGE_FORMAT

object InputView {

    fun readCarNames(): List<String> = readln().split(",")

    fun readAdvanceCount(): Int {
        while (true) {
            val count = readln()

            kotlin.runCatching { count.toInt() }
                .onSuccess { return count.toInt() }
                .onFailure { println(ERROR_MESSAGE_FORMAT.format(NUMBER_FORMAT_ERROR)) }
        }
    }
}

private const val NUMBER_FORMAT_ERROR = "Int형으로 변환할 수 있는 숫자로 입력해야 합니다."
