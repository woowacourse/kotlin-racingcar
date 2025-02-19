package view

object InputView {
    fun inputCarNames(): List<String> {
        println(INPUT_CAR_NAME_MESSAGE)
        return readLine()?.split(",")?.map { it.trim() } ?: emptyList()
    }

    fun inputRacingCount(): Int {
        val input = readLine(INPUT_COUNT_MESSAGE).trim()
        return input.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException(INVALID_COUNT_MESSAGE)
    }

    private fun readLine(message: String): String {
        println(message)
        return readlnOrNull() ?: ""
    }

    private const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val INPUT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    private const val INVALID_COUNT_MESSAGE = "시도할 횟수는 자연수여야 합니다."
}
