package racingcar

import racingcar.controller.RacingGame
import racingcar.input.InputView
import racingcar.input.OutputView
import java.util.*

fun main() {
    val inputView = InputView(Scanner(System.`in`))
    val outputView = OutputView()

    val racingGame = RacingGame(inputView, outputView)
    racingGame.playGame()
}