object InputView {
    fun inputCarNames(): List<String> {
        OutputView.outputCarNamesRequest()
        val input = readln()
        val carNames = input.split(",")
        return carNames
    }

    fun inputTrialCount(): Int {
        OutputView.outputTrialCountRequest()
        val input = readln()
        require(input.all { it.isDigit() }) { "입력값은 모두 숫자여야한다" }
        return input.toInt()
    }
}
