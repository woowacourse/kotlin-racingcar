package view

class InputView {
    fun inputCarName(): String = readLine(INPUT_CAR_NAME_MESSAGE)

    private fun readLine(message: String): String {
        println(message)
        return readlnOrNull() ?: ""
    }

    private companion object {
        const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    }
}