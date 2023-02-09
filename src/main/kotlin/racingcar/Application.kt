package racingcar

import racingcar.domain.RacingGame
import racingcar.domain.numbergenerator.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val generator = RandomNumberGenerator()
    RacingGame(inputView, outputView, generator).runGame()
}
