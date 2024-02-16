package racingcar

import racingcar.controller.CarRacing
import racingcar.view.input.ConsoleInputView
import racingcar.view.output.ConsoleOutputView

fun main() {
    val inputView = ConsoleInputView()
    val outputView = ConsoleOutputView()
    val carRacing = CarRacing(inputView, outputView)

    carRacing.play()
}
