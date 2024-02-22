package racingcar.view.input

class ConsoleInputView : InputView {
    override fun askCarNames(): List<String> {
        println(ENTER_CAR_NAMES)
        return readln().split(CAR_NAMES_DELIMITERS)
    }

    override fun askNumberOfAttempts(): Int {
        println(ENTER_NUMBER_OF_ATTEMPTS)
        return readln().toInt()
    }

    companion object {
        private const val ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)`를 기준으로 구분)."
        private const val ENTER_NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?"
        private const val CAR_NAMES_DELIMITERS = ","
    }
}
