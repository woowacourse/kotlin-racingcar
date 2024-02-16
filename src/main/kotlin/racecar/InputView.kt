class InputView {
    fun inputCarNames(input: String = readln()): List<String> = input.split(",").map { it.trim() }

    fun inputTrialCount(input: String = readln()): Int {
        require(input.all { it.isDigit() }) { "입력값은 모두 숫자여야한다" }
        return input.toInt()
    }
}
