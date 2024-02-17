package racecar

class KernelRaceCarGameInputView : RaceCarGameInputView {
    override fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readln().split(DELIMITER).map { it.trim() }
    }

    override fun inputTrialCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().also(::validateTrialCount).toInt()
    }

    private fun validateTrialCount(input: String) {
        check(input.all { it.isDigit() }) { "입력값은 모두 숫자여야한다" }
    }

    companion object {
        private const val DELIMITER = ","
    }
}
