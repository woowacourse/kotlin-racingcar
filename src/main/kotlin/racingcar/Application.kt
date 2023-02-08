package racingcar

import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    try {
        val inputView = InputView()
        val outputView = OutputView()
        RacingGame(inputView, outputView).runGame()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
