package racingcar

import racingcar.domain.RacingGame
import racingcar.domain.numbergenerator.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    try {
        val inputView = InputView()
        val outputView = OutputView()
        val generator = RandomNumberGenerator()
        RacingGame(inputView, outputView, generator).runGame()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
