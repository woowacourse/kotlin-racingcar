package racingcar.view

import racingcar.InputView

class ConsoleInputView : InputView {
    override fun readInput(): String = readln()
}
