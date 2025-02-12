package racingcar.view

class InputView {
    fun readCarNames(): String {
        println(CAR_NAMES_INPUT_MESSAGE)
        return readln()
    }

    fun readRounds(): String {
        println(ROUNDS_INPUT_MESSAGE)
        return readln()
    }

    companion object {
        const val CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val ROUNDS_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}
