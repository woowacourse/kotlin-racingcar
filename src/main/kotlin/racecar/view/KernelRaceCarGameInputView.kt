package racecar.view

class KernelRaceCarGameInputView : RaceCarGameInputView {
    override fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readln().split(DELIMITER).map { it.trim() }
    }

    override fun inputTrialCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().also(::validateTrialCount).toInt()
    }

    private fun validateTrialCount(trialCount: String) {
        trialCount.toIntOrNull() ?: throw IllegalArgumentException("입력값 $trialCount - 시도 횟수는 숫자여야 한다.")
    }

    companion object {
        private const val DELIMITER = ","
    }
}
