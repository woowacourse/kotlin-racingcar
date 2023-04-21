package view

class InputView {
    companion object {
        private fun printCarNameInputMessage() = println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        private fun printTrialCountInputMessage() = println("시도할 횟수는 몇 회인가요?")
        private const val CAR_NAME_DELIMITER = ","
    }

    fun readCarNames(): List<String> {
        printCarNameInputMessage()
        val carNames = readln()

        return carNames.split(CAR_NAME_DELIMITER).toList()
    }

    fun readTrialCount(): Int {
        printTrialCountInputMessage()
        val trialCount = readln()

        return trialCount.toInt()
    }
}
