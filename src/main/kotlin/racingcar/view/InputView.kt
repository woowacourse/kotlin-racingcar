package racingcar.view

class InputView {
    fun readCarNames(): String {
        println(CAR_NAMES_INPUT_MESSAGE)
        return readln()
    }

    companion object {
        val CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    }
}
