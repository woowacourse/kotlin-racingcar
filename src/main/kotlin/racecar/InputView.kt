class InputView {
    fun inputCarNames(carNames: String = readln()): List<String> = carNames.split(DELEMETER).map { it.trim() }

    fun inputTrialCount(trialCount: String = readln()): Int {
        require(trialCount.all { it.isDigit() }) { "입력값은 모두 숫자여야한다" }
        return trialCount.toInt()
    }

    companion object {
        private const val DELEMETER = ","
    }
}
