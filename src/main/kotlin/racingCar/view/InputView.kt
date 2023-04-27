package racingCar.view

class InputView {

    fun readCarNames(): List<String> {
        println("자동차 이름을 입력해주세요")
        val input = readLine() ?: throw IllegalArgumentException("이름을 입력하세요")
        return splitCarNames(input)
    }

    private fun splitCarNames(input: String): List<String> {
        return input.replace(" ", "").split(DELIMITER)
    }

    fun readTryCount(): Int {
        println("시도 횟수를 입력해주세요")
        val input = readLine() ?: throw IllegalArgumentException("시도 횟수를 입력해주세요")
        return input.toInt()
    }

    companion object {
        private const val DELIMITER: String = ","
    }
}
