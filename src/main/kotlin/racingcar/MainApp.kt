package racingcar

import racingcar.controller.GameController
import racingcar.input.InputView
import racingcar.input.OutputView
import java.util.*

fun main() {
    val inputView = InputView(Scanner(System.`in`))
    val outputView = OutputView()

    val controller = GameController(inputView, outputView)
    controller.playGame()
}