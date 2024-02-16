class RaceCarGameInputViewImpl : RaceCarGameInputView {
    override fun inputCarNames(): List<String> {
        return readln().split(DELEMITER).map { it.trim() }
    }

    override fun inputTrialCount(): Int {
        return readln().also(::validateTrialCount).toInt()
    }

    private fun validateTrialCount(input: String) {
        check(input.all { it.isDigit() }) { "입력값은 모두 숫자여야한다" }
    }

    companion object {
        private const val DELEMITER = ","
    }
}

interface RaceCarGameInputView {
    fun inputCarNames(): List<String>
    fun inputTrialCount(): Int
}